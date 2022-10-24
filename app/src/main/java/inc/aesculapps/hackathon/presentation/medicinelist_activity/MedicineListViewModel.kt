package inc.aesculapps.hackathon.presentation.medicinelist_activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedicineListViewModel: ViewModel() {

    val dummyMedicineList = mutableListOf<String>()

    val medicineDataToShow = MutableLiveData<List<String>>()

    init {
        dummyMedicineList.apply {
            add("Acetaminophen")
            add("Acetylcysteine")
            add("Actos")
            add("Acyclovir")
            add("Adderall")
            add("Adderall XR")
            add("Advair Diskus")
            add("Advil")
            add("Afinitor")
            add("Aimovig")
            add("Ajovy")
            add("Albuterol")
            add("Alecensa")
            add("Alendronate")
            add("Aleve")
            add("Alloprunol")
            add("Amantadine")
            add("Ambien")
            add("Amlodipine")
            add("Amoxicillin")
        }

        medicineDataToShow.value = dummyMedicineList

    }




}