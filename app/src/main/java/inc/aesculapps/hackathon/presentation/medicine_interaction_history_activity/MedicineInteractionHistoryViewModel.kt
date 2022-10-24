package inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.utils.MedicineInteractionHistoryData

class MedicineInteractionHistoryViewModel : ViewModel() {


    private val dummyMedInteractionHistoryList = mutableListOf(
        MedicineInteractionHistoryData(
            MedicineInteractionHistoryData.MEDICINE_ADDITION_TYPE,
            "Retinol",
            null,
            true,
            0
        ),
        MedicineInteractionHistoryData(
            MedicineInteractionHistoryData.MEDICINE_CHECK_TYPE,
            "Paracetamol",
            "Paratusin",
            false,
            3
        )
    )

    val medInteractionHistoryLiveData = MutableLiveData<MutableList<MedicineInteractionHistoryData>>()

    init {
        medInteractionHistoryLiveData.value = dummyMedInteractionHistoryList
    }




}