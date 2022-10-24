package inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.data

import com.google.android.gms.maps.model.LatLng

data class HealthcarePartner (
    val name: String,
    val address: String,
    val number: String,
    val latLng : LatLng
        )