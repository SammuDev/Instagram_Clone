package com.example.instagram_clone.register

import androidx.annotation.StringRes
import com.example.instagram_clone.common.base.BasePresenter
import com.example.instagram_clone.common.base.BaseView

interface RegisterEmail {
    interface Presenter : BasePresenter {
        fun create(email: String)
    }

    interface View : BaseView<Presenter> {
        fun displayEmailFailure(@StringRes emailError: Int?)
    }
}
