package com.example.instagram_clone.register

import androidx.annotation.StringRes
import com.example.instagram_clone.common.base.BasePresenter
import com.example.instagram_clone.common.base.BaseView

interface RegisterNameAndPassword {
    interface Presenter : BasePresenter {
        fun create(name: String, password: String, confirm: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayNameFailure(@StringRes nameError: Int?)
        fun displayPasswordFailure(@StringRes passError: Int?)
        fun onCreateSuccess(name: String)
        fun onCreateFailure(message: String)
    }
}
