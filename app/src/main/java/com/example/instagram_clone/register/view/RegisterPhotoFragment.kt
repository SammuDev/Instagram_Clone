package com.example.instagram_clone.register.view

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.instagram_clone.R
import com.example.instagram_clone.common.view.CropperImageFragment
import com.example.instagram_clone.common.view.CustomDialog
import com.example.instagram_clone.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {
    private var binding: FragmentRegisterPhotoBinding? = null
    private lateinit var fragmentAttachListener: FragmentAttachListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("cropkey") { requestKey, bundle ->
            val uri = bundle.getParcelable<Uri>(CropperImageFragment.KEY_URI)
            onCropImageResult(uri)
        }
    }

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
                    openDialog()
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

    private fun openDialog() {
        val customDialog = CustomDialog(requireContext())
        customDialog.addButton(R.string.photo, R.string.gallery) {
            when (binding?.registerButtonNext?.id) {
                R.string.photo -> Log.i("Teste", "FOTO")
                R.string.gallery -> fragmentAttachListener.goToGalleryScreen()
            }
        }
        customDialog.show()
    }

    private fun onCropImageResult(uri: Uri?) {
        if (uri != null) {
            binding?.registerImageViewProfile
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
