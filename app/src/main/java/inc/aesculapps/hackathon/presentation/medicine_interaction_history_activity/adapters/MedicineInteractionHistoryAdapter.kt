package inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import inc.aesculapps.hackathon.databinding.ActivityMedicineInteractionHistoryBinding
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMedinteractionhistoryBinding
import inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.utils.MedicineInteractionHistoryData

class MedicineInteractionHistoryAdapter(
    private val medicineInteractionHistoryList: List<MedicineInteractionHistoryData>
) : RecyclerView.Adapter<MedicineInteractionHistoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerviewitemMedinteractionhistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMedinteractionhistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val dataToBind = medicineInteractionHistoryList[position]

        if (position == 0) {
            view.separatorLine.visibility = View.GONE
        }

        when (dataToBind.dataType) {
            MedicineInteractionHistoryData.MEDICINE_ADDITION_TYPE -> {
                view.containerMedicineAdd.visibility = View.VISIBLE
                view.containerMedicineCheck.visibility = View.GONE

                view.medicineNameText.text = dataToBind.medicineName

                var statusString = "STATUS = "
                statusString += when (dataToBind.medicineConsumptionStatus) {
                    true -> "DIMINUM"
                    false -> "TIDAK DIMINUM"
                }
                view.consumptionStatus.text = statusString

                val counterString = "${dataToBind.medicineInteractionCounter} INTERAKSI"
                view.interactionCounterTextView.text = counterString
            }
            MedicineInteractionHistoryData.MEDICINE_CHECK_TYPE -> {
                view.containerMedicineAdd.visibility = View.GONE
                view.containerMedicineCheck.visibility = View.VISIBLE

                view.medicine1NameText.text = dataToBind.medicineName
                view.medicine2NameText.text = dataToBind.secondMedicineName

                var statusString = "STATUS = "
                statusString += when (dataToBind.medicineConsumptionStatus) {
                    true -> "DIMINUM"
                    false -> "TIDAK DIMINUM"
                }
                view.consumptionCheckStatus.text = statusString

                val counterString = "${dataToBind.medicineInteractionCounter} INTERAKSI"
                view.interactionCekCounterTextView.text = counterString

            }
        }

        view.root.setOnClickListener {
            Toast.makeText(
                view.root.context,
                "TO BE IMPLEMENTED",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {
        return medicineInteractionHistoryList.size
    }


}