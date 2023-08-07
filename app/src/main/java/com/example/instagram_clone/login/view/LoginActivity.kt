package com.example.instagram_clone.login.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail = findViewById<TextInputEditText>(R.id.login_editText_email)
        val editTextPassword = findViewById<TextInputEditText>(R.id.login_editText_password)

        editTextEmail.addTextChangedListener(watcher)
        editTextPassword.addTextChangedListener(watcher)

        findViewById<Button>(R.id.login_button_enter).setOnClickListener {
            findViewById<TextInputEditText>(R.id.login_edit_email_input)
                .error = "E-mail inválido!"

            findViewById<TextInputEditText>(R.id.login_edit_password_input)
                .error = "Senha incorreta!"
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            findViewById<Button>(R.id.login_button_enter).isEnabled = p0.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {
            TODO("Not yet implemented")
        }
    }
}
