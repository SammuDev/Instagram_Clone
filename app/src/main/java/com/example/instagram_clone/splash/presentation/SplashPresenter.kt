package com.example.instagram_clone.splash.presentation

import com.example.instagram_clone.splash.Splash
import com.example.instagram_clone.splash.data.SplashRepository

class SplashPresenter(private var view: Splash.View?, private val repository: SplashRepository) :
    Splash.Presenter {
    override fun authenticated() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        view = null
    }
}
