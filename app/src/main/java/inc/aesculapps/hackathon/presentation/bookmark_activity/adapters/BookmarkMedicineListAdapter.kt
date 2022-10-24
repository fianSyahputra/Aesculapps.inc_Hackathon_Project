package inc.aesculapps.hackathon.presentation.bookmark_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMedbookmarkBinding

class BookmarkMedicineListAdapter(
    private val medicineList: List<DummyMedicine>
): RecyclerView.Adapter<BookmarkMedicineListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerviewitemMedbookmarkBinding): RecyclerView.ViewHolder(binding.root)


    lateinit var goToMedicineDetailCallBack: (DummyMedicine)->Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMedbookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val data = medicineList[position]

        view.medicineImageView.setImageResource(data.imageSrc)
        view.medicineNameText.text = data.name

        view.root.setOnClickListener {
            goToMedicineDetailCallBack(data)
        }

    }

    override fun getItemCount(): Int {
        return medicineList.size
    }

}