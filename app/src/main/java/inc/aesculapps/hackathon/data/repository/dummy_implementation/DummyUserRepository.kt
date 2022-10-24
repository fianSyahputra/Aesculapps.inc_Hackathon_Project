package inc.aesculapps.hackathon.data.repository.dummy_implementation

import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.data.models.abstraction.MedicineConsumptionScheduleInterface
import inc.aesculapps.hackathon.data.models.abstraction.UserInterface
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyMedicine
import inc.aesculapps.hackathon.data.models.dummy_implementation.DummyUser
import inc.aesculapps.hackathon.data.models.implementation.MedicineConsumptionSchedule
import inc.aesculapps.hackathon.data.repository.abstraction.UserRepositoryInterface

class DummyUserRepository : UserRepositoryInterface {

    private val DummyUserDb = listOf<DummyUser>(
        DummyUser(
            1,
            "a",
            "a",
            "alvian",
            R.drawable.dummy_dev_profile_pic,
            listOf<DummyMedicine>(),
            mutableListOf<MedicineConsumptionSchedule>(),
            listOf()
        )
    )

    override fun getSingleUserData(id: Int): UserInterface? {
        var dataToReturn: UserInterface? = null
        DummyUserDb.forEach { data ->
            if (data.id == id) {
                dataToReturn = data
            }
        }
        return dataToReturn
    }

    override fun userLogin(username: String, password: String): UserInterface? {
        var dataToReturn: UserInterface? = null
        DummyUserDb.forEach { data ->
            if (data.username == username && data.password == password) {
                dataToReturn = data
            }
        }
        return dataToReturn
    }
}