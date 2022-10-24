package inc.aesculapps.hackathon.presentation.medicine_consumption_schedule_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule
import inc.aesculapps.hackathon.databinding.ActivityMedicineConsumptionScheduleBinding
import inc.aesculapps.hackathon.presentation.add_medicine_activity.AddMedicineActivity
import inc.aesculapps.hackathon.presentation.medicine_consumption_schedule_activity.adapters.MedicineConsumptionScheduleAdapter

class MedicineConsumptionScheduleActivity : AppCompatActivity() {

    companion object {
        const val MEDICINE_LIST_INTENT_NAME = "medicineList"
        const val MEDICINE_SCHEDULE_LIST_INTENT_NAME = "medicine schedule"

    }

    private lateinit var binding: ActivityMedicineConsumptionScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineConsumptionScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val medicineList =
            intent.getParcelableArrayListExtra<DummyMedicine>(MEDICINE_LIST_INTENT_NAME) as List<DummyMedicine>
        val medicineScheduleList = intent.getParcelableArrayListExtra<MedicineConsumptionSchedule>(
            MEDICINE_SCHEDULE_LIST_INTENT_NAME
        ) as List<MedicineConsumptionSchedule>

        binding.recyclerViewMedicineConsumptionSchedule.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = MedicineConsumptionScheduleAdapter(medicineList, medicineScheduleList as MutableList<MedicineConsumptionSchedule>)
        }

        binding.btnMedCheck.setOnClickListener {
            startActivity(Intent(applicationContext, AddMedicineActivity::class.java))
        }


    }
}