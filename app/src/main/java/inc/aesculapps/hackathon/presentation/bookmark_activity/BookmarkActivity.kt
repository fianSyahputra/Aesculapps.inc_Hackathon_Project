package inc.aesculapps.hackathon.presentation.bookmark_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.databinding.ActivityBookmarkBinding
import inc.aesculapps.hackathon.presentation.bookmark_activity.adapters.BookmarkMedicineListAdapter
import inc.aesculapps.hackathon.presentation.medicine_detail_activity.MedicineDetailActivity
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class BookmarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userData = LoginHandler.loggedInAccountData

        val dummyData = listOf(
            userData!!.medicineList[0],
            userData!!.medicineList[1],
            userData!!.medicineList[2],
            )

        binding.toolBarContainerInclude.toolbarText.text = "BOOKMARK"

        val bookmarkAdapter = BookmarkMedicineListAdapter(dummyData)
        bookmarkAdapter.goToMedicineDetailCallBack = {
            val intent = Intent(this, MedicineDetailActivity::class.java)
            intent.putExtra(MedicineDetailActivity.INTENT_DATA_NAME, it)
            startActivity(intent)
        }

        binding.recyclerviewMedBookmark.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = bookmarkAdapter
        }



    }
}