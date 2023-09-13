package com.example.instagram_clone.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone.common.util.TextWatcherr
import com.example.instagram_clone.databinding.ActivityLoginBinding
import com.example.instagram_clone.login.Login
import com.example.instagram_clone.login.presentation.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {
    private lateinit var binding: ActivityLoginBinding

    override lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter(this)

        with(binding) {
            loginEditTextEmail.addTextChangedListener(watcher)
            loginEditTextPassword.addTextChangedListener(watcher)

            loginButtonEnter.setOnClickListener {
                presenter.login(
                    loginEditTextEmail.text.toString(),
                    loginEditTextPassword.text.toString()
                )

//                Handler(Looper.getMainLooper()).postDelayed({
//                    loginButtonEnter.showProgress(false)
//                }, 2000)
            }
        }
    }

    private val watcher = TextWatcherr {
        binding.loginButtonEnter.isEnabled = it.isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.loginButtonEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginEditEmailInput.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginEditPasswordInput.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticator() {
        // IR À TELA PRINCIPAL
    }

    override fun onUserUnauthorized() {
        // MOSTRAR UM ALERTA
    }
}
