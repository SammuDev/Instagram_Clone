package com.example.instagram_clone.common.view

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

        binding?.let {
            with(it) {
//                a
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
