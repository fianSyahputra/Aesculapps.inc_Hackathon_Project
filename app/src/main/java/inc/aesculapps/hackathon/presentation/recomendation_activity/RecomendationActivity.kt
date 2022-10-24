package inc.aesculapps.hackathon.presentation.recomendation_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.databinding.ActivityRecomendationBinding
import inc.aesculapps.hackathon.presentation.add_medicine_activity.AddMedicineActivity
import inc.aesculapps.hackathon.presentation.home_activity.HomeActivity
import inc.aesculapps.hackathon.presentation.recomendation_activity.adapters.RecomendationMedicineConsumptionListAdapter
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class RecomendationActivity : AppCompatActivity() {

    //========== Activity Variables ==========//

    private lateinit var binding: ActivityRecomendationBinding
    private val viewModel = RecomendationViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userData = LoginHandler.loggedInAccountData

        val forUserNameText = "Hi! ${userData?.name}"
        binding.nameTextView.text = forUserNameText
        binding.userAgeTextView.text = "42 Tahun"
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            adapter = RecomendationMedicineConsumptionListAdapter(userData!!.medicineList,viewModel.dummyMedInteractionList, viewModel.dummyMedicineNamesFavoriteSearch)
        }

        binding.toolBarContainerInclude.backArrowBtn.setOnClickListener {
            onBackPressed()
        }

        binding.toolBarContainerInclude.closeBtn.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.toolBarContainerInclude.toolbarText.text = "Rekomendasiku"

        binding.medCheckBtn.setOnClickListener {
            startActivity(Intent(applicationContext, AddMedicineActivity::class.java))
        }

    }
}