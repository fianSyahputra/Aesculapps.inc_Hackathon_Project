package inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemForviewpagerPartnerlocationlistBinding
import inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.data.HealthcarePartner

class PartnersLocationAdapter(
    val partnerList: List<HealthcarePartner>
) : RecyclerView.Adapter<PartnersLocationAdapter.ViewHolder>(){


    inner class ViewHolder(val binding: RecyclerviewitemForviewpagerPartnerlocationlistBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemForviewpagerPartnerlocationlistBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val data = partnerList[position]

        view.partnerNameTextView.text = data.name
        view.addressTextView.text = data.address
        view.phoneTextView.text = data.number
    }

    override fun getItemCount(): Int {
        return partnerList.size
    }


}