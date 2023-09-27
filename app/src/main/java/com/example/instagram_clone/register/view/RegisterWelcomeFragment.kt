package com.example.instagram_clone.register.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.databinding.FragmentRegisterWelcomeBinding
import com.example.instagram_clone.main.view.MainActivity

class RegisterWelcomeFragment : Fragment(R.layout.fragment_register_welcome) {
    private var binding: FragmentRegisterWelcomeBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterWelcomeBinding.bind(view)

        val name =
            arguments?.getString(KEY_NAME) ?: throw IllegalArgumentException("Name not found")

        binding?.let {
            with(it) {
                registerTextWelcome.text = getString(R.string.welcome_to_instagram, name)

                registerButtonNext.setOnClickListener {
                    startActivity(Intent(context, MainActivity::class.java))
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val KEY_NAME = "key_name"
    }
}
