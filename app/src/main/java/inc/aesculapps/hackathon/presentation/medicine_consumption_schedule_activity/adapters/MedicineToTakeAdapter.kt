package inc.aesculapps.hackathon.presentation.medicine_consumption_schedule_activity.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMedicinetotakelistBinding
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler
import java.util.Calendar

class MedicineToTakeAdapter(
    val timeMember : MutableList<MedicineConsumptionSchedule>,
    val timeMemberDailyConsumptionIndex : MutableList<Int>
) : RecyclerView.Adapter<MedicineToTakeAdapter.ViewHolder>() {

    //========== CallBacks ==========//
    lateinit var onSwitchBecomePositiveCallBack : ()->Unit
    lateinit var onSwitchBecomeNegativeCallBack : ()->Unit



    lateinit var updateDailyConsumptionStatusCallBack: (Boolean, Int)-> Unit


    inner class ViewHolder(val binding: RecyclerviewitemMedicinetotakelistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMedicinetotakelistBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.binding.root.context

        val displayedTimeMember = timeMember[position]
        val displayedTimeMemberBeforeChange = timeMember[position]


        val consumptionStatus = timeMember[position].dailyConsumptionStatus[timeMemberDailyConsumptionIndex[position]]
        holder.binding.consumptionStatus.isChecked = consumptionStatus

        if (holder.binding.consumptionStatus.isChecked) {
            holder.binding.consumptionStatus.text = "Sudah Diminum"
        } else {
            holder.binding.consumptionStatus.text = "Belum Diminum"
        }

        holder.binding.consumptionStatus.setOnCheckedChangeListener { compoundButton, b ->
            when(b) {
                true ->{
                    onSwitchBecomePositiveCallBack()
                    holder.binding.consumptionStatus.text = "Sudah Diminum"
                    displayedTimeMember.dailyConsumptionStatus[position] = true

                }
                else ->{
                    onSwitchBecomeNegativeCallBack()
                    holder.binding.consumptionStatus.text = "Belum Diminum"
                    displayedTimeMember.dailyConsumptionStatus[position] = false
                }
            }



            var indexToChange = 0
            LoginHandler.loggedInAccountData!!.medicineConsumptionSchedule.forEach {
                    if (it.id == timeMember[position].id){
                        it.dailyConsumptionStatus[timeMemberDailyConsumptionIndex[position]] = timeMember[position].dailyConsumptionStatus[position]
                        Log.d("IndexToChange = ",indexToChange.toString())
                        Log.d("theMedName",it.medicineName)
                    }
            }

            Log.d("displayedTimeMemberId",displayedTimeMember.id.toString())
            Log.d("displayedTimeMemberName",displayedTimeMember.medicineName.toString())

        }



        holder.binding.medicineNameTextView.text = displayedTimeMember.medicineName

        val complaintStatusList =displayedTimeMember.dailyConsumptionComplaint

        when(complaintStatusList.isEmpty()){
            true -> {
                holder.binding.statusKeluhanTextView.text = "Tidak ada keluhan"
            }
            false -> {
                holder.binding.statusKeluhanTextView.text = displayedTimeMember.dailyConsumptionComplaint[position]
            }
        }

    }

    override fun getItemCount(): Int {
        return timeMember.size
    }



}