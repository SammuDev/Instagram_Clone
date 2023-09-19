package com.example.instagram_clone.register.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.common.util.TextWatcherr
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

                registerButtonNext.setOnClickListener {
                    presenter.create(
                        registerEditTextEmail.text.toString()
                    )
                }

                registerEditTextEmail.addTextChangedListener(watcher)
                registerEditTextEmail.addTextChangedListener(TextWatcherr {
                    displayEmailFailure(null)
                })
            }
        }
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TextWatcherr {
        binding?.registerButtonNext?.isEnabled =
            binding?.registerEditTextEmail?.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {}
    override fun displayEmailFailure(emailError: Int?) {}
    override fun onEmailFailure(message: String) {}
    override fun goToNameAndPasswordScreen(email: String) {}
}
