package inc.aesculapps.hackathon.presentation.home_activity.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.databinding.RecyclerviewitemsRiwayatPindaianBinding
import inc.aesculapps.hackathon.presentation.medicine_detail_activity.MedicineDetailActivity

class RiwayatPindaianAdapter(
    val medicineList: List<MedicineInterface>
) : RecyclerView.Adapter<RiwayatPindaianAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: RecyclerviewitemsRiwayatPindaianBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemsRiwayatPindaianBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = medicineList[position] as DummyMedicine
        holder.binding.imageView.setImageResource(data.imageSrc)
        holder.binding.medicineNameText.text = data.name

        holder.binding.root.setOnClickListener {
            val context = holder.binding.root.context
            val movingIntent = Intent(context, MedicineDetailActivity::class.java)
            movingIntent.putExtra(MedicineDetailActivity.INTENT_DATA_NAME, data)
            context.startActivity(movingIntent)
        }

    }

    override fun getItemCount(): Int {
        return medicineList.size
    }


}