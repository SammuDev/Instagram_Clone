package com.example.instagram_clone.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.common.view.CustomDialog
import com.example.instagram_clone.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {
    private var binding: FragmentRegisterPhotoBinding? = null
    private lateinit var fragmentAttachListener: FragmentAttachListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterPhotoBinding.bind(view)

        binding?.let { it ->
            with(it) {
                registerButtonJump.setOnClickListener {
                    fragmentAttachListener.goToMainScreen()
                }

                registerButtonNext.isEnabled = true
                registerButtonNext.setOnClickListener {
                    val customDialog = CustomDialog(requireContext())
                    customDialog.addButton(R.string.photo, R.string.gallery) {
                        openDialog(R.string.photo, R.string.gallery)
                    }
                    customDialog.show()
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

    private fun openDialog(photo: String, gallery: String) {
        when (binding?.registerButtonNext?.id) {
            R.string.photo -> Log.i("Teste", "FOTO")
            R.string.gallery -> Log.i("Teste", "GALERIA")
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
