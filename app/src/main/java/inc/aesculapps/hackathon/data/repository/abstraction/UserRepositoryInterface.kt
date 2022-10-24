package inc.aesculapps.hackathon.data.repository.abstraction

import inc.aesculapps.hackathon.data.models.abstraction.UserInterface

interface UserRepositoryInterface {

    fun getSingleUserData(id: Int): UserInterface?

    fun userLogin(username: String, password: String): UserInterface?


}