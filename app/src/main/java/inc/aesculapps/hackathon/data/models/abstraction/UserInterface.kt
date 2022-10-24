package inc.aesculapps.hackathon.data.models.abstraction

import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedInteraction
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule

interface UserInterface {

    val id: Int
    val username: String
    val password: String
    val name: String
    var medicineList: List<DummyMedicine>
    var medicineConsumptionSchedule: MutableList<MedicineConsumptionSchedule>
    var medicineInteractionList: List<DummyMedInteraction>

}