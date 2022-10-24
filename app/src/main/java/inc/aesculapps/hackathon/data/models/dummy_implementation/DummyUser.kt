package inc.aesculapps.hackathon.data.models.dummy_implementation

import inc.aesculapps.hackathon.data.models.abstraction.MedInteractionInterface
import inc.aesculapps.hackathon.data.models.abstraction.MedicineConsumptionScheduleInterface
import inc.aesculapps.hackathon.data.models.abstraction.MedicineInterface
import inc.aesculapps.hackathon.data.models.abstraction.UserInterface
import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule

data class DummyUser(
    override val id: Int,
    override val username: String,
    override val password: String,
    override val name: String,
    val imageSrc: Int,
    override var medicineList: List<DummyMedicine>,
    override var medicineConsumptionSchedule: MutableList<MedicineConsumptionSchedule>,
    override var medicineInteractionList: List<DummyMedInteraction>

) : UserInterface {
}