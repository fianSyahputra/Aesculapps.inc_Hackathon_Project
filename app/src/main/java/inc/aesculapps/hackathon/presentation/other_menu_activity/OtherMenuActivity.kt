package inc.aesculapps.hackathon.presentation.other_menu_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.databinding.ActivityOtherMenuBinding
import inc.aesculapps.hackathon.presentation.bookmark_activity.BookmarkActivity
import inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.HealthcarePartnerMapsActivity
import inc.aesculapps.hackathon.presentation.home_activity.utils.ShortCutMenu
import inc.aesculapps.hackathon.presentation.insurance_activity.InsuranceActivity
import inc.aesculapps.hackathon.presentation.medicine_consumption_schedule_activity.MedicineConsumptionScheduleActivity
import inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.MedicineInteractionHistoryActivity
import inc.aesculapps.hackathon.presentation.medicine_news_activity.MedicineNewsActivity
import inc.aesculapps.hackathon.presentation.medicinelist_activity.MedicineListActivity
import inc.aesculapps.hackathon.presentation.other_menu_activity.adapters.OtherMenuActivityAdapter
import inc.aesculapps.hackathon.presentation.recomendation_activity.RecomendationActivity
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class OtherMenuActivity : AppCompatActivity() {

    lateinit var binding : ActivityOtherMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val otherMenuAdapter = OtherMenuActivityAdapter(prepareMenuShortcutList())
        otherMenuAdapter.menuClickedCallBack = {
            startActivity(it)
        }


        binding.toolBarContainerInclude.toolbarText.text = "MENU LAINNYA"
        binding.recyclerviewOthermenu.apply {
            layoutManager = GridLayoutManager(applicationContext,3)
            adapter = otherMenuAdapter
        }



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
                    Intent(applicationContext, MedicineConsumptionScheduleActivity::class.java).apply {
                        val medicineListAsArray = ArrayList(LoginHandler.loggedInAccountData!!.medicineList)
                        val medicineConsumptionScheduleAsArray =
                            ArrayList(LoginHandler.loggedInAccountData!!.medicineConsumptionSchedule)
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
                    "NEWS", R.drawable.ic_baseline_shortcutmenu_news,
                    Intent(applicationContext, MedicineNewsActivity::class.java)
                )
            )
        }

        return menuShortcutList
    }
}