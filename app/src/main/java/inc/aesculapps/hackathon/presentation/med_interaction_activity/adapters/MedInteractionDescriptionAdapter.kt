package inc.aesculapps.hackathon.presentation.med_interaction_activity.adapters

import android.content.res.ColorStateList
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.abstraction.MedInteractionInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedInteraction
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMedinteractiondescriptionBinding
import java.lang.Thread.State

class MedInteractionDescriptionAdapter(
    private val medInteractionDataList: List<MedInteractionInterface>
) : RecyclerView.Adapter<MedInteractionDescriptionAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: RecyclerviewitemMedinteractiondescriptionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMedinteractiondescriptionBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = medInteractionDataList[position]
        val context = holder.binding.root.context
        var arrowIsDown = true
        holder.binding.apply {
            val warningLevelResources = getWarningLevelResources(data.warningLevel)
            warningImageView.setImageResource(warningLevelResources.warningLogoSrc)
            arrowImageView.setImageResource(warningLevelResources.downArrowSrc)
            arrowImageView.setOnClickListener {
                when(arrowIsDown) {
                    true -> {
                        arrowImageView.setImageResource(warningLevelResources.upArrowSrc)
                        medInteractionName.visibility = View.VISIBLE
                        containerMedInteractionDescriptionAndName.visibility = View.VISIBLE
                    }
                    false -> {
                        arrowImageView.setImageResource(warningLevelResources.downArrowSrc)
                        containerMedInteractionDescriptionAndName.visibility = View.GONE
                    }
                }
                arrowIsDown = arrowIsDown.not()
            }

            val color = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                context.getColor(warningLevelResources.color)}
             else {
                context.resources.getColor(warningLevelResources.color)
             }

            medInteractionDescription.setTextColor(color)
            medInteractionName.setTextColor(color)
            bothMedicineNameTextView.setTextColor(color)

            medInteractionDescription.text = data.description
            medInteractionName.text = data.interactionName
            val medicinesName = data.med1Name+" - "+data.med2Name
            bothMedicineNameTextView.text = medicinesName

            //  Interaction name and description is not shown when started
            containerMedInteractionDescriptionAndName.visibility = View.GONE


        }
    }

    override fun getItemCount(): Int {
        return medInteractionDataList.size
    }

    private fun getWarningLevelResources(warningLevel:Int): WarningLevelsResources{
        return when(warningLevel){
            0 -> {
                WarningLevelsResources(
                    R.color.Aesculapps_medInteraction_purple,
                    R.drawable.ic_baseline_keyboard_arrow_up_purple,
                    R.drawable.ic_baseline_keyboard_arrow_down_purple,
                    R.drawable.ic_baseline_warning_purple
                )
            }
            1 -> {
                WarningLevelsResources(
                    R.color.Aesculapps_medInteraction_yellow,
                    R.drawable.ic_baseline_keyboard_arrow_up_yellow,
                    R.drawable.ic_baseline_keyboard_arrow_down_yellow,
                    R.drawable.ic_baseline_warning_yellow
                )
            }
            2 -> {
                WarningLevelsResources(
                    R.color.Aesculapps_medInteraction_red,
                    R.drawable.ic_baseline_keyboard_arrow_up_red,
                    R.drawable.ic_baseline_keyboard_arrow_down_red,
                    R.drawable.ic_baseline_warning_red
                )
            }
            else -> {
                WarningLevelsResources(
                    R.color.black,
                    R.drawable.ic_baseline_keyboard_arrow_up_yellow,
                    R.drawable.ic_baseline_keyboard_arrow_down_purple,
                    R.drawable.ic_baseline_warning_red
                )
            }
        }
    }


    private inner class WarningLevelsResources(
        val color: Int,
        val upArrowSrc: Int,
        val downArrowSrc: Int,
        val warningLogoSrc: Int
    )



}