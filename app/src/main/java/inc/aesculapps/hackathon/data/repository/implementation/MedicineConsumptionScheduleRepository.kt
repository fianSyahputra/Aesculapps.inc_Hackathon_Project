package inc.aesculapps.hackathon.data.repository.implementation

import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule
import inc.aesculapps.hackathon.data.repository.abstraction.MedicineConsumptionScheduleRepositoryInterface
import java.util.*

class MedicineConsumptionScheduleRepository : MedicineConsumptionScheduleRepositoryInterface {

    private val dummylastConsumptionDateOmeprazole = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2023)
        set(Calendar.MONTH, Calendar.DECEMBER)
        set(Calendar.DATE, 31)
    }

    private val dummyDailyConsumptionScheduleOmeprazole = listOf(
        Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 13)
            set(Calendar.MINUTE, 0)
        },
        Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 1)
            set(Calendar.MINUTE, 0)
        }
    )

    private val dummylastConsumptionDateAntasida = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2023)
        set(Calendar.MONTH, Calendar.DECEMBER)
        set(Calendar.DATE, 31)
    }

    private val dummyDailyConsumptionScheduleAntasida = listOf(
        Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 21)
            set(Calendar.MINUTE, 0)
        }
    )


    private val tidakAdaKeluhanString = "Hingga saat ini tidak ada keluhan"

    val dummyDb = mutableListOf(
        MedicineConsumptionSchedule(
            1,
            "OMEPRAZOL 20mg",
            dummylastConsumptionDateOmeprazole,
            dummyDailyConsumptionScheduleOmeprazole,
            mutableListOf(false, false),
            listOf()
        ),
        MedicineConsumptionSchedule(
            2,
            "ANTASIDA DOEN SEQUEST",
            dummylastConsumptionDateAntasida,
            dummyDailyConsumptionScheduleAntasida,
            mutableListOf(false),
            listOf()
        )

        )

    override fun getAllUserMedicineConsumptionScheduleData(userId: Int): MutableList<MedicineConsumptionSchedule> {
        return dummyDb
    }
}