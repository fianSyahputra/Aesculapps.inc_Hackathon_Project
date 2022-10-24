package inc.aesculapps.hackathon.presentation.add_medicine_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import inc.aesculapps.hackathon.databinding.ActivityAddMedicineBinding
import inc.aesculapps.hackathon.presentation.add_medicine_activity.utils.MedicineAdditionConfimationDialog
import inc.aesculapps.hackathon.presentation.home_activity.HomeActivity
import inc.aesculapps.hackathon.presentation.med_interaction_activity.MedInteractionActivity
import inc.aesculapps.hackathon.presentation.medicine_detail_activity.MedicineDetailActivity
import inc.aesculapps.hackathon.presentation.medicine_scan_activity.MedicineScanActivity
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class AddMedicineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMedicineBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.toolBarContainerInclude.toolbarText.text = "Tambah Obat"


        binding.actionSwitch.setOnCheckedChangeListener { p0, p1 ->
            when (p1) {
                true -> {
                    binding.containerInteractionCheck.visibility = View.VISIBLE
                    binding.actionBtn.text = "Cek Interaksi"
                    binding.actionSwitch.text = "Cek Interaksi Obat"
                }
                false -> {
                    binding.containerInteractionCheck.visibility = View.GONE
                    binding.actionBtn.text = "Tambah Obat"
                    binding.actionSwitch.text = "Tambah Obat"
                }
            }
        }

        binding.actionSwitch.isChecked = false

        binding.containerInteractionCheck.visibility = View.GONE

        binding.actionBtn.setOnClickListener {
            var intent : Intent? = null
            if (!binding.actionSwitch.isChecked) {

                val confirmDialog = MedicineAdditionConfimationDialog()
                confirmDialog.addBtnOnClickCallBack = {
                    intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext, "Data Ditambahkan", Toast.LENGTH_LONG
                    ).show()
                    finish()
                }

                confirmDialog.show(supportFragmentManager, null)
            } else {
                intent = Intent(applicationContext, MedInteractionActivity::class.java)
                val dataInArrayList =
                    ArrayList(LoginHandler.loggedInAccountData!!.medicineInteractionList)
                intent!!.putExtra(MedInteractionActivity.INTENT_DATA_NAME, dataInArrayList)
                startActivity(intent)
                finish()

            }
        }

        binding.cameraMed1.setOnClickListener {
            goToScanActivity()
        }
        binding.cameraMed2.setOnClickListener {
            goToScanActivity()
        }

    }

    private fun goToScanActivity(){
        val intent = Intent(applicationContext, MedicineScanActivity::class.java)
        startActivity(intent)
    }

}