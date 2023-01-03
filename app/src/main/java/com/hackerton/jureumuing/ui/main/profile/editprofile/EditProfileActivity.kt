package com.hackerton.jureumuing.ui.main.profile.editprofile

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.hackerton.jureumuing.databinding.ActivityEditProfileBinding
import com.hackerton.jureumuing.ui.BaseActivity

class EditProfileActivity :
    BaseActivity<ActivityEditProfileBinding>(ActivityEditProfileBinding::inflate) {

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            try {
                Glide.with(this).load(uri).into(binding.ivProfileImage)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    private val OPEN_GALLERY = 1
    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initButton()
    }

    private fun initButton() {
        binding.ivCameraIcon.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}

