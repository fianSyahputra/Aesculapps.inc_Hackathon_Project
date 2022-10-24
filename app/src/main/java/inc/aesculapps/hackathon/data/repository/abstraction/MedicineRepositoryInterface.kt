package inc.aesculapps.hackathon.data.repository.abstraction

import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface

interface MedicineRepositoryInterface {

    fun getSingleMedicineData(id: Int): MedicineInterface?

    fun getUserMedicineList(userId: Int): List<MedicineInterface>?



}