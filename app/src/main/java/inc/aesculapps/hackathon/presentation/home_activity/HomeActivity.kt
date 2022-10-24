package inc.aesculapps.hackathon.presentation.home_activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyUser
import inc.aesculapps.hackathon.databinding.ActivityHomeBinding
import inc.aesculapps.hackathon.presentation.add_medicine_activity.AddMedicineActivity
import inc.aesculapps.hackathon.presentation.bookmark_activity.BookmarkActivity
import inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.HealthcarePartnerMapsActivity
import inc.aesculapps.hackathon.presentation.home_activity.adapters.MenuShortcutAdapter
import inc.aesculapps.hackathon.presentation.home_activity.adapters.RiwayatPindaianAdapter
import inc.aesculapps.hackathon.presentation.home_activity.utils.ShortCutMenu
import inc.aesculapps.hackathon.presentation.insurance_activity.InsuranceActivity
import inc.aesculapps.hackathon.presentation.login_activity.LoginActivity
import inc.aesculapps.hackathon.presentation.med_interaction_activity.MedInteractionActivity
import inc.aesculapps.hackathon.presentation.medicine_consumption_schedule_activity.MedicineConsumptionScheduleActivity
import inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.MedicineInteractionHistoryActivity
import inc.aesculapps.hackathon.presentation.medicine_news_activity.MedicineNewsActivity
import inc.aesculapps.hackathon.presentation.medicine_news_activity.adapters.MedicineNewsAdapter
import inc.aesculapps.hackathon.presentation.medicine_news_activity.data.News
import inc.aesculapps.hackathon.presentation.medicinelist_activity.MedicineListActivity
import inc.aesculapps.hackathon.presentation.other_menu_activity.OtherMenuActivity
import inc.aesculapps.hackathon.presentation.recomendation_activity.RecomendationActivity
import inc.aesculapps.hackathon.utils.apps_notifiation_manager.AppsNotificationManager
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler


class HomeActivity : AppCompatActivity() {

    //========== Activity Variables ==========//
    lateinit var binding: ActivityHomeBinding

    private lateinit var viewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //  Check if the user have logged in. If not, go to login page

        if (!LoginHandler.isLoggedIn()) {
            val movingIntent = Intent(this, LoginActivity::class.java)
            movingIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(movingIntent)
            finish()
        } else {

            //  Register Notification Channel
            registerNotificationChannel()

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(0, AppsNotificationManager.getBasicNotificationManager(applicationContext).build())
            }

            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)

            viewModel = HomeViewModel()







            viewModel.name.observe(this) {
                binding.userName.text = it
            }

            viewModel.riwayatPindaianList.observe(this) {
                val riwayatPindaianAdapter = RiwayatPindaianAdapter(it)
                val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerViewRiwayatPindaian.apply {
                    this.layoutManager = layoutManager
                    adapter = riwayatPindaianAdapter
                }
            }

            binding.recyclerViewMenuShortcut.apply {
                layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
                adapter = MenuShortcutAdapter(prepareMenuShortcutList())
            }


            binding.medicineInteractionCountText.setOnClickListener {
                val movingIntent = Intent(this, MedInteractionActivity::class.java)
                val dataToSend = viewModel.userData!!.medicineInteractionList
                val dataInArrayList = ArrayList(dataToSend)
                movingIntent.putParcelableArrayListExtra(
                    MedInteractionActivity.INTENT_DATA_NAME,
                    dataInArrayList
                )
                startActivity(movingIntent)

            }

            binding.containerMedicineSchedule.setOnClickListener {
                val movingIntent = Intent(this, MedicineConsumptionScheduleActivity::class.java)
                val medicineListAsArray = ArrayList(viewModel.userData!!.medicineList)
                val medicineConsumptionScheduleAsArray =
                    ArrayList(viewModel.userData!!.medicineConsumptionSchedule)
                movingIntent.apply {
                    this.putParcelableArrayListExtra(
                        MedicineConsumptionScheduleActivity.MEDICINE_LIST_INTENT_NAME,
                        medicineListAsArray
                    )
                    this.putParcelableArrayListExtra(
                        MedicineConsumptionScheduleActivity.MEDICINE_SCHEDULE_LIST_INTENT_NAME,
                        medicineConsumptionScheduleAsArray
                    )
                }
                startActivity(movingIntent)
            }

            val newsList = listOf(
                News(
                    "Title 1",
                    resources.getString(R.string.lorem_ipsum_30),
                    R.drawable.dummy_bpjs_kesehatan
                ),
                News(
                    "Title 2",
                    resources.getString(R.string.lorem_ipsum_30),
                    R.drawable.dummy_fg_troches
                ),
                News(
                    "Title 3",
                    resources.getString(R.string.lorem_ipsum_30),
                    R.drawable.dummy_panadol_extra
                )
            )

            binding.recyclerViewBeritaObat.apply {
                layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                adapter =
                    MedicineNewsAdapter(newsList, Intent(context, MedicineNewsActivity::class.java))
            }

            binding.checkMedicineBtn.setOnClickListener {
                startActivity(Intent(applicationContext, AddMedicineActivity::class.java))
            }


        }


    }

    override fun onResume() {
        super.onResume()
        viewModel.updateUserData()
    }

    private fun prepareMenuShortcutList(): List<ShortCutMenu> {
        val menuShortcutList = mutableListOf<ShortCutMenu>()
        menuShortcutList.apply {
            add(
                ShortCutMenu(
                    "DAFTAR OBAT", R.drawable.ic_baseline_shortcutmenu_daftarobat,
                    Intent(applicationContext, MedicineListActivity::class.java)
                )
            )
            add(
                ShortCutMenu(
                    "RIWAYAT CEK INTERAKSI OBAT",
                    R.drawable.ic_baseline_shortcutmenu_riwayatcekinteraksiobat,
                    Intent(applicationContext, MedicineInteractionHistoryActivity::class.java)
                )
            )
            add(
                ShortCutMenu(
                    "REKOMENDASIKU", R.drawable.ic_baseline_shortcutmenu_rekomendasiku,
                    Intent(applicationContext, RecomendationActivity::class.java)
                )
            )
            add(
                ShortCutMenu(
                    "JADWALKU", R.drawable.ic_baseline_shortcutmenu_jadwalku,
                    Intent(
                        applicationContext,
                        MedicineConsumptionScheduleActivity::class.java
                    ).apply {
                        val medicineListAsArray = ArrayList(viewModel.userData!!.medicineList)
                        val medicineConsumptionScheduleAsArray =
                            ArrayList(viewModel.userData!!.medicineConsumptionSchedule)
                        this.putParcelableArrayListExtra(
                            MedicineConsumptionScheduleActivity.MEDICINE_LIST_INTENT_NAME,
                            medicineListAsArray
                        )
                        this.putParcelableArrayListExtra(
                            MedicineConsumptionScheduleActivity.MEDICINE_SCHEDULE_LIST_INTENT_NAME,
                            medicineConsumptionScheduleAsArray
                        )
                    }
                )
            )
            add(
                ShortCutMenu(
                    "MITRA FASKES", R.drawable.ic_baseline_shortcutmenu_mitrafaskes,
                    Intent(applicationContext, HealthcarePartnerMapsActivity::class.java)
                )
            )
            add(
                ShortCutMenu(
                    "ASURANSIKU", R.drawable.ic_baseline_shortcutmenu_asuransiku,
                    Intent(applicationContext, InsuranceActivity::class.java)
                )
            )
            add(
                ShortCutMenu(
                    "BOOKMARK", R.drawable.ic_baseline_shortcutmenu_bookmark,
                    Intent(applicationContext, BookmarkActivity::class.java)

                )
            )
            add(
                ShortCutMenu(
                    "MENU LAINNYA", R.drawable.ic_baseline_shortcutmenu_menulainnya,
                    Intent(applicationContext, OtherMenuActivity::class.java)
                )
            )
        }

        return menuShortcutList
    }


    //========== Notification Channel Related  ==========//
    private val CHANNEL_NAME = "AESCULAPPS_CHANNEL"
    private val CHANNEL_DESCRIPTION = "CHANNEL DESCRIPTION"
    private val CHANNEL_IMPORTANCE_LEVEL = NotificationManager.IMPORTANCE_DEFAULT


    private fun registerNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                AppsNotificationManager.BASIC_NOTIFICATION_CHANNEL_ID,
                CHANNEL_NAME,
                CHANNEL_IMPORTANCE_LEVEL
            ).apply {
                description = CHANNEL_DESCRIPTION
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }


    }
}