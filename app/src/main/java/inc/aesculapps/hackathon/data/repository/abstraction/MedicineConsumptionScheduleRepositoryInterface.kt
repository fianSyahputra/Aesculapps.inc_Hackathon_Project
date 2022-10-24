package inc.aesculapps.hackathon.data.repository.abstraction

import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule

interface MedicineConsumptionScheduleRepositoryInterface {

    fun getAllUserMedicineConsumptionScheduleData(userId: Int): List<MedicineConsumptionSchedule>

}