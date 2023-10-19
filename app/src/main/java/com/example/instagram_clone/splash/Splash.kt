package com.example.instagram_clone.splash

import com.example.instagram_clone.common.base.BasePresenter
import com.example.instagram_clone.common.base.BaseView

interface Splash {
    interface Presenter : BasePresenter {
        fun authenticated()
    }

    interface View : BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()
    }
}
