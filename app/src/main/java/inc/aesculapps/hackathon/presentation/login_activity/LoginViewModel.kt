package inc.aesculapps.hackathon.presentation.login_activity

import androidx.lifecycle.ViewModel
import inc.aesculapps.hackathon.data.models.abstraction.UserInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyUser
import inc.aesculapps.hackathon.data.repository.abstraction.UserRepositoryInterface
import inc.aesculapps.hackathon.data.repository.dummy_implementation.DummyMedInteractionRepository
import inc.aesculapps.hackathon.data.repository.dummy_implementation.DummyMedicineRepository
import inc.aesculapps.hackathon.data.repository.dummy_implementation.DummyUserRepository
import inc.aesculapps.hackathon.data.repository.implementation.MedicineConsumptionScheduleRepository
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class LoginViewModel: ViewModel() {


    private  var userData : UserInterface? = null

    private val userRepo: UserRepositoryInterface = DummyUserRepository()
    private val medicineRepo = DummyMedicineRepository()
    private val medInteractionRepo = DummyMedInteractionRepository()
    private val medConsumptionScheduleRepo = MedicineConsumptionScheduleRepository()


    lateinit var loginErrorCallBack: (String)->Unit
    lateinit var loginSuccessCallBack: (UserInterface)-> Unit

    fun login(username: String, password: String){
        userData = userRepo.userLogin(username, password)
        if(userData == null) {
            loginErrorCallBack("Kombinasi username dan password tidak ditemukan")
        }
        else {
            prepareUserData(userData!!.id)
            loginSuccessCallBack(userData!!)
        }
    }

    fun prepareUserData(userId: Int){
        val medicineData = medicineRepo.getUserMedicineList(userId)
        val medicineConsumptionScheduleData = medConsumptionScheduleRepo.getAllUserMedicineConsumptionScheduleData(userId)
        val medInteractionData = medInteractionRepo.getDummyData()

        userData!!.apply {
            this.medicineList = medicineData as List<DummyMedicine>
            this.medicineConsumptionSchedule = medicineConsumptionScheduleData
            this.medicineInteractionList = medInteractionData
        }
    }





}