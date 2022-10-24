package inc.aesculapps.hackathon.presentation.login_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout
import inc.aesculapps.hackathon.databinding.ActivityLoginBinding
import inc.aesculapps.hackathon.presentation.home_activity.HomeActivity
import inc.aesculapps.hackathon.utils.login_handler.LoginHandler

class LoginActivity : AppCompatActivity() {

    //========== Activity Variables ==========//
    private lateinit var binding: ActivityLoginBinding
    private  val viewModel = LoginViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //========== ViewModel CallBacks Initialization ==========//
        viewModel.loginErrorCallBack = {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        viewModel.loginSuccessCallBack = {
            setLoginFormErrorMessage("", "")
            binding.passwordEditText.setText("")
            LoginHandler.setLoggedIn(true)
            LoginHandler.loggedInAccountData = it
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.usernameEditText.setText("")
        binding.passwordEditText.setText("")
        binding.passwordTextInputLayout.endIconMode = TextInputLayout.END_ICON_NONE


        binding.passwordEditText.addTextChangedListener {
            if (binding.passwordEditText.text?.isEmpty() == true) {
                binding.passwordTextInputLayout.endIconMode = TextInputLayout.END_ICON_NONE


            } else if (binding.passwordTextInputLayout.endIconMode == TextInputLayout.END_ICON_NONE) {
                binding.passwordTextInputLayout.endIconMode =
                    TextInputLayout.END_ICON_PASSWORD_TOGGLE
            }
        }

        binding.loginButton.setOnClickListener {

            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            when (LoginCheck.Run(username, password)) {
                LoginCheck.USERNAME_AND_PASSWORD_EMPTY -> setLoginFormErrorMessage(
                    "Username tidak boleh kosong",
                    "Password tidak boleh kosong"
                )
                LoginCheck.USERNAME_EMPTY -> setLoginFormErrorMessage(
                    "Username tidak boleh kosong",
                    ""
                )
                LoginCheck.PASSWORD_EMPTY -> setLoginFormErrorMessage(
                    "",
                    "Password tidak boleh kosong"
                )
                LoginCheck.PASS -> {
                    viewModel.login(username, password)
                }
            }

        }

    }

    private fun setLoginFormErrorMessage(usernameErrMsg: String, passwordErrMsg: String) {
        if (usernameErrMsg.isNotEmpty()) {
            binding.usernameEditText.setError(usernameErrMsg)
        }

        if (passwordErrMsg.isNotEmpty()) {
            binding.passwordEditText.setError(passwordErrMsg)
            binding.passwordTextInputLayout.endIconMode = TextInputLayout.END_ICON_NONE
        }


    }

}