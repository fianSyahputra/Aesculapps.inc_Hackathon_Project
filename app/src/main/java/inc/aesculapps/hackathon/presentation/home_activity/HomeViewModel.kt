package inc.aesculapps.hackathon.presentation.home_activity

import android.content.Intent
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.abstraction.MedInteractionInterface
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedInteraction
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.repository.abstraction.MedInteractionRepositoryInterface
import inc.aesculapps.hackathon.data.repository.dummy_implementation.DummyMedInteractionRepository
import inc.aesculapps.hackathon.data.repository.implementation.MedicineConsumptionScheduleRepository
import inc.aesculapps.hackathon.presentation.home_activity.adapters.MenuShortcutAdapter
import inc.aesculapps.hackathon.presentation.home_activity.adapters.RiwayatPindaianAdapter
import inc.aesculapps.hackathon.presentation.home_activity.utils.ShortCutMenu
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler
import inc.aesculapps.hackathon.utils.riwayat_pindaian_handler.RiwayatPindaianHandler
import org.json.JSONArray
import org.json.JSONObject

class HomeViewModel : ViewModel() {

    //========== Repositories ==========//
    private val medInteractionRepo: MedInteractionRepositoryInterface =
        DummyMedInteractionRepository()
    private val medConsumptionScheduleRepo = MedicineConsumptionScheduleRepository()


    //========== ViewModel Variables ==========//
    val name = MutableLiveData<String>()

    val medicineInteractionCount = MutableLiveData<String>()

    val riwayatPindaianList = MutableLiveData<List<MedicineInterface>>()

    var userData = LoginHandler.loggedInAccountData


    init {
        name.value = "Hi, " + userData?.name
        getMedicineInteractionData()
        //  For Development Purposes
        riwayatPindaianList.value = RiwayatPindaianHandler.getDummyCache()

        //  It should be the code below, not above
        //riwayatPindaianList.value = RiwayatPindaianHandler.cache
    }


    fun getMedicineInteractionData() {

        val result =
            (medInteractionRepo as DummyMedInteractionRepository).getDummyData()

        if (result.isEmpty()) {
            medicineInteractionCount.value = "Tidak Ada Interaksi Obat Yang Anda Konsumsi"
        } else {
            userData!!.medicineInteractionList = result
            medicineInteractionCount.value =
                "Ada ${userData!!.medicineInteractionList.size} Interaksi Obat Yang Anda Konsumsi"
        }


    }

    fun updateUserData() {
        userData = LoginHandler.loggedInAccountData

        userData!!.medicineConsumptionSchedule.forEach {
            Log.d("#medconsumptionschedule", "name = ${it.medicineName}")
            Log.d("#medconsumptionschedule", "id = ${it.id}")
            it.dailyConsumptionStatus.forEach { b ->

                Log.d("#dailyConsumptionStatus", b.toString())

            }

        }

    }


}