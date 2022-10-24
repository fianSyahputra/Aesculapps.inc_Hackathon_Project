package inc.aesculapps.hackathon.presentation.medicine_news_activity.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.aesculapps.hackathon.databinding.RecyclerviewitemMedicinenewsBinding
import inc.aesculapps.hackathon.presentation.medicine_news_activity.data.News

class MedicineNewsAdapter(
    private val newsList : List<News>,
    val intent: Intent? = null
): RecyclerView.Adapter<MedicineNewsAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: RecyclerviewitemMedicinenewsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewitemMedicinenewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.binding
        val data = newsList[position]

        view.newsImageView.setImageResource(data.imageSrc)
        view.newsTitleText.text = data.title
        view.newsDetail.text = data.detail

        view.root.setOnClickListener {
            if (intent != null){
                view.root.context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}