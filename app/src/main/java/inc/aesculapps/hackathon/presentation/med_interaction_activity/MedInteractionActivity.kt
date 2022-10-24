package inc.aesculapps.hackathon.presentation.med_interaction_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedInteraction
import inc.aesculapps.hackathon.databinding.ActivityMedInteractionBinding
import inc.aesculapps.hackathon.presentation.add_medicine_activity.AddMedicineActivity
import inc.aesculapps.hackathon.presentation.med_interaction_activity.adapters.MedInteractionDescriptionAdapter

class MedInteractionActivity : AppCompatActivity() {

    companion object{
        const val INTENT_DATA_NAME = "MedInteractionActivity_IntentDataName"
    }

    private lateinit var binding : ActivityMedInteractionBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val data = intent.getParcelableArrayListExtra<DummyMedInteraction>(INTENT_DATA_NAME)
        
        if (data.isNullOrEmpty()) {
            binding.recyclerViewMedInteractionDescription.visibility = View.GONE
            binding.tidakAdaInteraksiTextView.visibility = View.VISIBLE
            binding.medInteractionCounterTextView.text = "0"
        }
        else {
            binding.tidakAdaInteraksiTextView.visibility = View.GONE
            binding.recyclerViewMedInteractionDescription.apply {
                visibility = View.VISIBLE
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
                adapter = MedInteractionDescriptionAdapter(data)
            }
            binding.medInteractionCounterTextView.text = data.size.toString()
        }

        binding.backArrowBtn.setOnClickListener { onBackPressed() }
        binding.closeBtn.setOnClickListener { onBackPressed() }

        binding.btnMedCheck.setOnClickListener {
            startActivity(Intent(applicationContext, AddMedicineActivity::class.java))
        }
    }



}