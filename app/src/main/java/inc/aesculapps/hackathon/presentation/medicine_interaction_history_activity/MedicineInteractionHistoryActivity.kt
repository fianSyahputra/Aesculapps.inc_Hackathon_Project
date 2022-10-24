package inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.databinding.ActivityMedicineInteractionHistoryBinding
import inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.adapters.MedicineInteractionHistoryAdapter

class MedicineInteractionHistoryActivity : AppCompatActivity() {

    //========== Activity Variables ==========//
    private lateinit var binding: ActivityMedicineInteractionHistoryBinding
    private val viewModel = MedicineInteractionHistoryViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineInteractionHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.medInteractionHistoryLiveData.observe(this){
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                adapter = MedicineInteractionHistoryAdapter(it)
            }
        }

        binding.toolBarContainerInclude.toolbarText.text = "RIWAYAT PENCARIAN INTERAKSI"





    }
}