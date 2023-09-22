package com.example.instagram_clone.register.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.common.base.DependencyInjector
import com.example.instagram_clone.common.util.TextWatcherr
import com.example.instagram_clone.databinding.FragmentRegisterEmailBinding
import com.example.instagram_clone.register.RegisterEmail
import com.example.instagram_clone.register.presentation.RegisterEmailPresenter

class RegisterEmailFragment : Fragment(R.layout.fragment_register_email), RegisterEmail.View {
    private var binding: FragmentRegisterEmailBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterEmailBinding.bind(view)

        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterEmailPresenter(this, repository)

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
        fragmentAttachListener = null
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }

    private val watcher = TextWatcherr {
        binding?.registerButtonNext?.isEnabled =
            binding?.registerEditTextEmail?.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerButtonNext?.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding?.registerEditTextEmail?.error = emailError?.let { getString(it) }
    }

    override fun onEmailFailure(message: String) {
        binding?.registerEditTextEmail?.error = message
    }

    override fun goToNameAndPasswordScreen(email: String) {
        fragmentAttachListener?.goToNameAndPasswordScreen(email)
    }
}
