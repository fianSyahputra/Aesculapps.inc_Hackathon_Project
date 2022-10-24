package inc.aesculapps.hackathon.presentation.medicine_interaction_history_activity.utils

data class MedicineInteractionHistoryData(
    var dataType: Int,
    var medicineName: String,
    var secondMedicineName: String?,
    var medicineConsumptionStatus: Boolean,
    var medicineInteractionCounter: Int
) {

    companion object {
        const val MEDICINE_ADDITION_TYPE = 0
        const val MEDICINE_CHECK_TYPE = 1
    }

}