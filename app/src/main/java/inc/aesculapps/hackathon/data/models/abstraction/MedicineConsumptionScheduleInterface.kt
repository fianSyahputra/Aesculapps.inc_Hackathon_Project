package inc.aesculapps.hackathon.data.models.abstraction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Calendar

interface MedicineConsumptionScheduleInterface {

    val id: Int
    val medicineName: String
    val lastConsumptionDate : Calendar
    val dailyConsumptionTime: List<Calendar>
    val dailyConsumptionStatus : List<Boolean>
    val dailyConsumptionComplaint: List<String>

}