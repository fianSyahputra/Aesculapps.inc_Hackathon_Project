package inc.aesculapps.hackathon.presentation.medicinelist_activity

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import inc.aesculapps.hackathon.databinding.ActivityMedicineListBinding
import inc.aesculapps.hackathon.presentation.medicinelist_activity.adapters.MedicineNameListAdapter
import kotlinx.coroutines.*
import java.lang.Thread.sleep

class MedicineListActivity : AppCompatActivity() {

    //========== Activity Variables ==========//
    private lateinit var binding : ActivityMedicineListBinding
    private val viewModel = MedicineListViewModel()
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        


        //  Livedata Observer
        viewModel.medicineDataToShow.observe(this){
            binding.recyclerviewMedicineList.apply {
                layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                adapter = MedicineNameListAdapter(it)
            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {


            override fun onQueryTextSubmit(query: String?): Boolean {
                // TODO: TO BE IMPLEMENTED !!
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // TODO: TO BE IMPLEMENTED!!
                return false
            }

        })


    }
}