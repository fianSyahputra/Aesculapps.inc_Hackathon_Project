package inc.aesculapps.hackathon.data.models.implementation

import android.os.Parcelable
import inc.aesculapps.hackathon.data.models.abstraction.MedicineConsumptionScheduleInterface
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class MedicineConsumptionSchedule(
    override val id: Int,
    override val medicineName: String,
    override val lastConsumptionDate: Calendar,
    override val dailyConsumptionTime: List<Calendar>,
    override val dailyConsumptionStatus: MutableList<Boolean>,
    override val dailyConsumptionComplaint: List<String>
) : MedicineConsumptionScheduleInterface, Parcelable {
}