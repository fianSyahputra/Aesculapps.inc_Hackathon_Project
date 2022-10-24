package inc.aesculapps.hackathon.presentation.recomendation_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.databinding.RecyclerviewitemActivityrecomendationBinding

class RecomendationMedicineConsumptionListAdapter(
    private val medicineList : List<DummyMedicine>,
    private val interactionListString: List<String>,
    /**
     * Below Variable is just  a dummy dependency
     */
    private val medicineFavoriteSearchList : List<String>
) : RecyclerView.Adapter<RecomendationMedicineConsumptionListAdapter.ViewHolder>() {



    inner class ViewHolder(val binding: RecyclerviewitemActivityrecomendationBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemActivityrecomendationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val data = medicineList[position]


        view.medicineNameText.text = data.name

        var isExtendedContainerShowing = false
        view.upDownArrowImageView.apply {
            setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_black)
            setOnClickListener {
                isExtendedContainerShowing = isExtendedContainerShowing.not()
                if (isExtendedContainerShowing) {
                    setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_black)
                    view.extendedDataContainer.visibility = View.VISIBLE
                }
                else {
                    setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_black)
                    view.extendedDataContainer.visibility = View.GONE

                }
            }
        }
        view.extendedDataContainer.visibility = View.GONE


        view.recyclerViewInteractionList.apply {
            this.layoutManager = LinearLayoutManager(view.root.context, LinearLayoutManager.VERTICAL, false)
            adapter = RecomendationMedicineInteractionListAdapter(interactionListString)
        }



        view.recyclerviewListOfFavoriteSearch.apply {
            this.layoutManager = LinearLayoutManager(view.root.context, LinearLayoutManager.VERTICAL, false)
            adapter = RecomendationMedicineFavoriteSearchAdapter(medicineFavoriteSearchList)
        }



    }

    override fun getItemCount(): Int {
        return medicineList.size
    }


}