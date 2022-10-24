package inc.aesculapps.hackathon.presentation.login_activity

class LoginCheck {

    companion object {
        const val USERNAME_AND_PASSWORD_EMPTY = 0
        const val USERNAME_EMPTY = 1
        const val PASSWORD_EMPTY = 2
        const val PASS = 100

        fun Run(username: String, password: String): Int{

            return when{
                username.isEmpty() and password.isEmpty() -> USERNAME_AND_PASSWORD_EMPTY
                password.isEmpty() -> PASSWORD_EMPTY
                username.isEmpty() -> USERNAME_EMPTY
                else -> PASS
            }

        }

    }
}