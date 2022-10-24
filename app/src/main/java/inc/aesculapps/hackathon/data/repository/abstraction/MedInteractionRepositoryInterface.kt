package inc.aesculapps.hackathon.data.repository.abstraction

import inc.aesculapps.hackathon.data.models.abstraction.MedInteractionInterface
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface

interface MedInteractionRepositoryInterface {

    fun getInteractionDataBetweenTwoMedicine(firstMedId: Int, secondMedId: Int): MedInteractionInterface?

    fun getAllUserMedicineInteraction(userMedicineList: List<MedicineInterface>) : List<MedInteractionInterface>?

}