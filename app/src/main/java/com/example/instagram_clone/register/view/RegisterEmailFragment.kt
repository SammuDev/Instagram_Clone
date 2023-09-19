package com.example.instagram_clone.register.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.databinding.FragmentRegisterEmailBinding
import com.example.instagram_clone.register.RegisterEmail

class RegisterEmailFragment : Fragment(R.layout.fragment_register_email), RegisterEmail.View {
    private var binding: FragmentRegisterEmailBinding? = null
    override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterEmailBinding.bind(view)

        binding?.let {
            with(it) {
                registerTextViewLogin.setOnClickListener {
                    activity?.finish()
                }

                registerEditTextEmail.addTextChangedListener(watcher)
            }
        }
    }

    override fun displayEmailFailure(emailError: Int?) {}

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }
}
