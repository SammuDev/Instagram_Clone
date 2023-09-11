package com.example.instagram_clone.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram_clone.R
import com.example.instagram_clone.common.view.CustomDialog
import com.example.instagram_clone.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment() {
    private var binding: FragmentRegisterPhotoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customDialog = CustomDialog(requireContext())
        customDialog.addButton(R.string.photo, R.string.gallery) {
            when (it.id) {
                R.string.photo -> Log.i("Teste", "FOTO")
                R.string.gallery -> Log.i("Teste", "GALERIA")
            }
        }
        customDialog.show()
    }
}
