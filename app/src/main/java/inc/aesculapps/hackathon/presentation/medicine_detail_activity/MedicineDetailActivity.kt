package inc.aesculapps.hackathon.presentation.medicine_detail_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.databinding.ActivityMedicineDetailBinding

class MedicineDetailActivity : AppCompatActivity() {


    companion object{
        const val INTENT_DATA_NAME = "MedicineDetailActivity_IntentDataName"
    }

    private lateinit var binding: ActivityMedicineDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = intent.getParcelableExtra<DummyMedicine>(INTENT_DATA_NAME)
        if (data == null) {
            Toast.makeText(this, "No DummyMedicine Data found", Toast.LENGTH_LONG).show()
            onBackPressed()
        }
        else {
            binding.medicineNameText.text = data.name

            if (data.category.isNotEmpty()) {
                binding.kategoriTextView.text = data.category
            }
            else {
                binding.descriptionSubtitleKategori.visibility = View.GONE
                binding.kategoriTextView.visibility = View.GONE
            }
            val dummyMedDesc = resources.getString(R.string.dummy_medicine_description)
            binding.medicineDescriptionTextView.text = dummyMedDesc

            binding.backArrow.setOnClickListener {
                onBackPressed()
            }

            binding.btnDarurat.setOnClickListener {
                Toast.makeText(this, "To Be Implemented !!", Toast.LENGTH_LONG).show()
            }

            if (data.imageSrc::class.simpleName == "Int") {
                binding.medicineImageView.setImageResource(data.imageSrc)
            }
            else {
                Toast.makeText(this, "data.imageSrc is not Int!", Toast.LENGTH_LONG).show()
            }

        }




    }
}