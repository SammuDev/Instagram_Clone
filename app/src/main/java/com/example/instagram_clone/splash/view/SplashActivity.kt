package com.example.instagram_clone.splash.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone.common.base.DependencyInjector
import com.example.instagram_clone.databinding.ActivitySplashBinding
import com.example.instagram_clone.login.view.LoginActivity
import com.example.instagram_clone.main.view.MainActivity
import com.example.instagram_clone.splash.Splash
import com.example.instagram_clone.splash.presentation.SplashPresenter

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), Splash.View {
    private lateinit var binding: ActivitySplashBinding
    override lateinit var presenter: Splash.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        val repository = DependencyInjector.splashRepository()
        presenter = SplashPresenter(this, repository)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goToLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
