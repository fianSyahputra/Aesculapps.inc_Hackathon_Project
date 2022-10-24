package inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.databinding.ActivityHealthcarePartnerMapsBinding
import inc.aesculapps.hackathon.presentation.add_medicine_activity.AddMedicineActivity
import inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.adapters.PartnersLocationAdapter
import inc.aesculapps.hackathon.presentation.healthcare_partner_location_activity.data.HealthcarePartner

class HealthcarePartnerMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityHealthcarePartnerMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHealthcarePartnerMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val surabaya = LatLng(-7.250445, 112.768845)


        val partnersList = listOf(
            HealthcarePartner(
                "Rumah Sakit Bhayangkara",
                "Jl. Ahmad Yani No.116, Ketintang, Kec. Gayungan, Kota SBY, Jawa Timur 60231",
                "0318292227",
                LatLng(-7.32468,112.7293183)
            ),
            HealthcarePartner(
                "Rumah Sakit Premier Surabaya",
                "Jl. Nginden Intan Barat No.Blok B, Nginden Jangkungan, Kec. Sukolilo, Kota SBY, Jawa Timur 60118",
                "0315993211",
                LatLng(-7.3044826,112.7630603)
            ),
            HealthcarePartner(
                "Siloam Hospitals Surabaya",
                "Jl. Raya Gubeng No.70, Gubeng, Kec. Gubeng, Kota SBY, Jawa Timur 60281",
                "03199206900",
                LatLng(-7.2741903,112.7438462)
            ),
            HealthcarePartner(
                "Rumah Sakit Islam Jemursari",
                "Jl. Raya Jemursari No.51-57, Jemur Wonosari, Kec. Wonocolo, Kota SBY, Jawa Timur 60237",
                "0318292227",
                LatLng(-7.322894,112.7377022)
            ),
        )



        partnersList.forEach {
            mMap.addMarker(
                MarkerOptions().position(it.latLng).title(it.name)
            )
        }

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(surabaya))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(partnersList[0].latLng,12.0f))

        binding.viewpager2.adapter = PartnersLocationAdapter(partnersList)
        binding.viewpager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                repopulateMMapMarkers(partnersList, position)
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(partnersList[position].latLng,12.0f))

            }
        })

        binding.btnMakeScheduleWithPartner.setOnClickListener {
            Toast.makeText(applicationContext, "To Be Implemented!", Toast.LENGTH_LONG).show()
        }

    }

    private fun repopulateMMapMarkers(data: List<HealthcarePartner>, showingIndex: Int){
        mMap.clear()
        var index = 0
        data.forEach {

            when{
                index == showingIndex -> {
                    mMap.addMarker(
                        MarkerOptions().position(it.latLng).title(it.name)
                    )?.showInfoWindow()
                }
                else -> {
                    mMap.addMarker(
                        MarkerOptions().position(it.latLng).title(it.name)
                    )
                }
            }
            index++
        }
    }

}