package inc.aesculapps.hackathon.presentation.insurance_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.databinding.ActivityInsuranceBinding
import inc.aesculapps.hackathon.presentation.insurance_activity.data.Insurance
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class InsuranceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsuranceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsuranceBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val bpjs = Insurance(
            "BPJS Kesehatan",
            R.drawable.dummy_bpjs_kesehatan,
            "3221189657894",
            "Klinik Aesculapeus Medika",
            "Aktif"
        )

        val userData = LoginHandler.loggedInAccountData

        binding.toolBarContainerInclude.userProfileImageView.setImageResource(R.drawable.dummy_dev_profile_pic)
        binding.toolBarContainerInclude.toolbarText.text = "ASURANSIKU"
        binding.insuranceImageView.setImageResource(bpjs.imageSrc)
        binding.insuranceNameTextBox.text = bpjs.name
        binding.insuranceCardNumberTextBox.text = bpjs.cardNumber
        binding.insuranceHealthCarePartnerTextBox.text = bpjs.healthCarePartner
        binding.insuranceMembershipStatusTextBox.text = bpjs.membershipStatus


    }
}