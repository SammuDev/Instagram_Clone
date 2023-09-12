package com.example.instagram_clone.common.util

import android.text.Editable
import android.text.TextWatcher

class TextWatcherr(val onTextChanged: (String) -> Unit) : TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {
    }
}
