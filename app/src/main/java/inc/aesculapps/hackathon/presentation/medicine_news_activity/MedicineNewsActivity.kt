package inc.aesculapps.hackathon.presentation.medicine_news_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.databinding.ActivityMedicineNewsBinding
import inc.aesculapps.hackathon.presentation.medicine_news_activity.adapters.MedicineNewsAdapter
import inc.aesculapps.hackathon.presentation.medicine_news_activity.data.News

class MedicineNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMedicineNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsList = listOf(
            News(
                "Title 1",
                resources.getString(R.string.lorem_ipsum_30),
                R.drawable.dummy_bpjs_kesehatan
            ),
            News(
                "Title 2",
                resources.getString(R.string.lorem_ipsum_30),
                R.drawable.dummy_fg_troches
            ),
            News(
                "Title 3",
                resources.getString(R.string.lorem_ipsum_30),
                R.drawable.dummy_panadol_extra
            )
        )

        binding.toolBarContainerInclude.toolbarText.text = "BERITA OBAT"
        binding.recyclerviewMedNews.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            adapter = MedicineNewsAdapter(newsList)
        }




    }
}