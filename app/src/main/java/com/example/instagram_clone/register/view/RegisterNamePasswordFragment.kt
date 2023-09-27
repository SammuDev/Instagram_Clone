package com.example.instagram_clone.register.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.common.base.DependencyInjector
import com.example.instagram_clone.common.util.TextWatcherr
import com.example.instagram_clone.databinding.FragmentRegisterNamePasswordBinding
import com.example.instagram_clone.register.RegisterNameAndPassword
import com.example.instagram_clone.register.presentation.RegisterNameAndPasswordPresenter

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password),
    RegisterNameAndPassword.View {

    private var binding: FragmentRegisterNamePasswordBinding? = null

    override lateinit var presenter: RegisterNameAndPassword.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterNamePasswordBinding.bind(view)

        val repository = DependencyInjector.registerRepository()
        val presenter = RegisterNameAndPasswordPresenter(this, repository)
        val email =
            arguments?.getString(KEY_EMAIL) ?: throw IllegalArgumentException("Email not found")

        binding?.let {
            with(it) {
                registerTextViewLogin.setOnClickListener {
                    activity?.finish()
                }

                registerNameButtonNext.setOnClickListener {
                    presenter.create(
                        email,
                        registerEditTextName.text.toString(),
                        registerEditTextPassword.text.toString(),
                        registerEditTextConfirm.text.toString(),
                    )
                }

                registerEditTextName.addTextChangedListener(watcher)
                registerEditTextPassword.addTextChangedListener(watcher)
                registerEditTextConfirm.addTextChangedListener(watcher)

                registerEditTextName.addTextChangedListener(TextWatcherr {
                    displayNameFailure(null)
                })
                registerEditTextPassword.addTextChangedListener(TextWatcherr {
                    displayPasswordFailure(null)
                })
                registerEditTextConfirm.addTextChangedListener(TextWatcherr {
                    displayPasswordFailure(null)
                })
            }
        }
    }

    private val watcher = TextWatcherr {
        binding?.registerNameButtonNext?.isEnabled =
            binding?.registerEditTextName?.text.toString().isNotEmpty()
                    && binding?.registerEditTextConfirm?.text.toString().isNotEmpty()
                    && binding?.registerEditTextConfirm?.text.toString().isNotEmpty()
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerNameButtonNext?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
        binding?.registerEditTextName?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passError: Int?) {
        binding?.registerEditTextPassword?.error = passError?.let { getString(it) }
    }

    override fun onCreateSuccess(name: String) {
//        TODO: Abrir tela de bem vindo
    }

    override fun onCreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}
