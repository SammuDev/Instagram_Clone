package com.example.instagram_clone.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import com.example.instagram_clone.R
import com.example.instagram_clone.databinding.DialogCustomBinding

class CustomDialog(context: Context) : Dialog(context) {
    private lateinit var textsButton: Array<TextView>
    private lateinit var binding: DialogCustomBinding

    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setTitle(titleId: Int) {
        this.titleId = titleId
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
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.show()
        titleId?.let {
            binding.dialogTitle.setText(it)
        }
        for (textView in textsButton) {
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(30, 50, 30, 50)
            binding.dialogContainer.addView(textView, layoutParams)
        }
    }
}
