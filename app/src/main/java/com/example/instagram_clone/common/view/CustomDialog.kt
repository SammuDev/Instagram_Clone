package com.example.instagram_clone.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.instagram_clone.R

class CustomDialog(context: Context) : Dialog(context) {
    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var textsButton: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLinearLayout = findViewById(R.id.dialog_container)
    }

    fun addButton(vararg texts: Int, listener: View.OnClickListener) {
        textsButton = Array(texts.size) {
            TextView(context)
        }
        texts.forEachIndexed { idx, text ->
            textsButton[idx].id = text
            textsButton[idx].setText(text)
            textsButton[idx].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()
        for (textView in textsButton) {
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(30, 50, 30, 50)
            dialogLinearLayout.addView(textView, layoutParams)
        }
    }
}