package inc.aesculapps.hackathon.presentation.medicine_consumption_schedule_activity.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMedicinescheduleBinding
import java.util.Calendar

class MedicineConsumptionScheduleAdapter(

    private val medicineList : List<DummyMedicine>,
    private val medicineConsumptionScheduleList: MutableList<MedicineConsumptionSchedule>

) : RecyclerView.Adapter<MedicineConsumptionScheduleAdapter.ViewHolder>() {


    private var medicineConsumptionScheduleIdTracker = mutableListOf<Int>()


    private val timeNote = mutableListOf<String>()
    private val timeNoteCalendar = mutableListOf<Calendar>()
    private val timeMember = mutableListOf<MutableList<MedicineConsumptionSchedule>>()
    private val timeMemberDailyConsumptionIndex = mutableListOf<MutableList<Int>>()


    init {

        val sharedIndex = 0
        val timeSharedIndex = 0
        medicineConsumptionScheduleList.forEach { mcs->
            medicineConsumptionScheduleIdTracker.add(sharedIndex,mcs.id)

            var dailyConsumptionIndex = 0
            mcs.dailyConsumptionTime.forEach{


                val time = extractTimeInString(it)
                if(timeNote.contains(time)){
                    val theTimeSharedIndex = timeNote.indexOf(time)
                    timeMember[theTimeSharedIndex].add(mcs)
                    timeMemberDailyConsumptionIndex[theTimeSharedIndex].add(dailyConsumptionIndex)
                }
                else {
                    timeNote.add(timeSharedIndex,time)
                    timeNoteCalendar.add(timeSharedIndex,it)
                    timeMember.add(sharedIndex, mutableListOf(mcs))
                    timeMemberDailyConsumptionIndex.add(sharedIndex, mutableListOf(dailyConsumptionIndex))

                }
                dailyConsumptionIndex++
            }

        }

    }

    inner class ViewHolder(val binding: RecyclerviewitemMedicinescheduleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMedicinescheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.binding.root.context

        val time = extractTimeInString(timeNoteCalendar[position])

        val medicineToTakeAdapter = MedicineToTakeAdapter(timeMember[position], timeMemberDailyConsumptionIndex[position])

        val medicineToTakeTotal = timeMember[position].size
        var medicineTakenTotal = 0

        //  Count medicineTakenTotal
        timeMember[position].forEach {
            it.dailyConsumptionStatus.forEach { status ->
                if(status) {
                    medicineTakenTotal++
                }
            }
        }



        medicineToTakeAdapter.apply {
            onSwitchBecomeNegativeCallBack = {
                medicineTakenTotal -= 1
                holder.binding.medicineConsumptionStatusTextView.text = "Belum Selesai"
            }
            onSwitchBecomePositiveCallBack = {
                medicineTakenTotal += 1
                if (medicineToTakeTotal == medicineTakenTotal) {
                    holder.binding.medicineConsumptionStatusTextView.text = "Sudah"
                }
            }
        }

        holder.binding.recyclerviewMedicineToTake.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = medicineToTakeAdapter
        }



        holder.binding.medicineConsumptionTimeTextView.text = timeNote[position]

        //  Check if now is the time to take the medicine or not yet
        val calendar = Calendar.getInstance()
        if (calendar.get(Calendar.HOUR_OF_DAY) < timeNoteCalendar[position].get(Calendar.HOUR_OF_DAY) ){
            holder.binding.medicineConsumptionStatusTextView.text = "Belum Waktunya"
        }
        else {
            if (medicineToTakeTotal == medicineTakenTotal) {
                holder.binding.medicineConsumptionStatusTextView.text = "Sudah"
            }
            else {
                holder.binding.medicineConsumptionStatusTextView.text = "Belum Selesai"
            }
        }


    }

    override fun getItemCount(): Int {
        return timeNote.size
    }


    private fun extractTimeInString(calendar: Calendar): String {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return "$hour.$minute"

    }



}