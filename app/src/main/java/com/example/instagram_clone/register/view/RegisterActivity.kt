package com.example.instagram_clone.register.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone.R
import com.example.instagram_clone.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {
    private lateinit var binding: ActivityRegisterBinding

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterEmailFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.register_fragment, fragment)
            commit()
        }
    }

    override fun goToNameAndPasswordScreen(email: String) {
        TODO("Not yet implemented")
    }
}
