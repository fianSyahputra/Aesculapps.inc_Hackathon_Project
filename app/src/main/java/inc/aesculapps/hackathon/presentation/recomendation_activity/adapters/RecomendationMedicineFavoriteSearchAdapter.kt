package inc.aesculapps.hackathon.presentation.recomendation_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemActivityrecomendationFavoritesearchlistBinding

class RecomendationMedicineFavoriteSearchAdapter(
    val medicineNameList : List<String>
) : RecyclerView.Adapter<RecomendationMedicineFavoriteSearchAdapter.ViewHolder>(){


    inner class ViewHolder(val binding: RecyclerviewitemActivityrecomendationFavoritesearchlistBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemActivityrecomendationFavoritesearchlistBinding.inflate(
            LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val data = medicineNameList[position]

        view.medicineNameText.text = data

    }

    override fun getItemCount(): Int {
        return medicineNameList.size
    }


}