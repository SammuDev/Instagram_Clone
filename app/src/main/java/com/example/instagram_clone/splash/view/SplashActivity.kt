package com.example.instagram_clone.splash.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram_clone.R
import com.example.instagram_clone.databinding.ActivitySplashBinding
import com.example.instagram_clone.splash.Splash

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), Splash.View {
    private lateinit var binding: ActivitySplashBinding
    override lateinit var presenter: Splash.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun goToMainScreen() {
        TODO("Not yet implemented")
    }

    override fun goToLoginScreen() {
        TODO("Not yet implemented")
    }
}
