package com.example.instagram_clone.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone.common.util.TextWatcherr
import com.example.instagram_clone.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loginEditTextEmail.addTextChangedListener(TextWatcherr {
                loginButtonEnter.isEnabled =
                    it.isNotEmpty()
            })
            loginEditTextPassword.addTextChangedListener(TextWatcherr {
                loginButtonEnter.isEnabled =
                    it.isNotEmpty()
            })

            loginButtonEnter.setOnClickListener {
                loginButtonEnter.showProgress(true)
                loginEditEmailInput.error = "E-mail inválido!"
                loginEditPasswordInput.error = "Senha inválida!"

                Handler(Looper.getMainLooper()).postDelayed({
                    loginButtonEnter.showProgress(false)
                }, 2000)
            }
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(p0: Editable?) {
            TODO("Not yet implemented")
        }
    }
}
