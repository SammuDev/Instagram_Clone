package com.example.instagram_clone.common.view

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.databinding.FragmentImageCropperBinding

class CropperImageFragment : Fragment(R.layout.fragment_image_cropper) {
    private var binding: FragmentImageCropperBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentImageCropperBinding.bind(view)

        val uri = arguments?.getParcelable<Uri>(KEY_URI)

        binding?.let {
            with(it) {
                cropperContainer.setAspectRatio(1, 1)
                cropperContainer.setFixedAspectRatio(true)
                cropperContainer.setImageUriAsync(uri)
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val KEY_URI = "key_uri"
    }
}
