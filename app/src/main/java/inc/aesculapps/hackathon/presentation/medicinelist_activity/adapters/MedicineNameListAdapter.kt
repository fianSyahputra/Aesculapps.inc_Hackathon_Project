package inc.aesculapps.hackathon.presentation.medicinelist_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemActivitymedicinelistBinding

class MedicineNameListAdapter(
    private val medicineNameList: List<String>
): RecyclerView.Adapter<MedicineNameListAdapter.ViewHolder>() {



    inner class ViewHolder(val binding: RecyclerviewitemActivitymedicinelistBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemActivitymedicinelistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.medicineNameText.text = medicineNameList[position]
    }

    override fun getItemCount(): Int {
        return medicineNameList.size
    }

}