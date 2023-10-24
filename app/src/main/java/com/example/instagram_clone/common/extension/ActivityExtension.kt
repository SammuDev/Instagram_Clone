package com.example.instagram_clone.common.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val imm: InputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

    var view: View? = currentFocus
    if (view == null) {
        view = View(this)
    }

    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.animationEnd(callback: () -> Unit): AnimatorListenerAdapter {
    return object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            callback.invoke()
        }
    }
}
