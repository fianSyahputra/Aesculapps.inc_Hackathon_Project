package inc.aesculapps.hackathon.utils.login_handler

import inc.aesculapps.hackathon.data.models.abstraction.UserInterface

class LoginHandler {

    companion object {

        private var loginStatus : Boolean = false
        var loggedInAccountData : UserInterface? = null

        fun setLoggedIn(loginStatus: Boolean){
            this.loginStatus = loginStatus
        }

        fun isLoggedIn(): Boolean{
            return loginStatus
        }

    }

}