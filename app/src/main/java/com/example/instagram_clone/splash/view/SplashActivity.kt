package com.example.instagram_clone.splash.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram_clone.common.base.DependencyInjector
import com.example.instagram_clone.common.extension.animationEnd
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

        binding.splashImg.animate().apply {
            setListener(animationEnd {
                presenter.authenticated()
            })
            duration = 1000
            alpha(1.0f)
            start()
        }

        presenter.authenticated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun goToMainScreen() {
        binding.splashImg.animate().apply {
            setListener(animationEnd {
                val intent = Intent(baseContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            })
            duration = 1000
            startDelay = 1000
            alpha(0.0f)
            start()
        }
    }

    override fun goToLoginScreen() {
        binding.splashImg.animate().apply {
            setListener(animationEnd {
                val intent = Intent(baseContext, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            })
            duration = 1000
            startDelay = 1000
            alpha(0.0f)
            start()
        }
    }
}
