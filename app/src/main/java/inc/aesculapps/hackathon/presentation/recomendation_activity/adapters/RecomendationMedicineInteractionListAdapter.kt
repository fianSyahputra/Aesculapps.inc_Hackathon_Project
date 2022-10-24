package inc.aesculapps.hackathon.presentation.recomendation_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemActivityrecomendationInteractionlistBinding

class RecomendationMedicineInteractionListAdapter(
    private val interactionStringList: List<String>
) : RecyclerView.Adapter<RecomendationMedicineInteractionListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerviewitemActivityrecomendationInteractionlistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemActivityrecomendationInteractionlistBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textView.text = interactionStringList[position]
    }

    override fun getItemCount(): Int {
        return interactionStringList.size
    }

}