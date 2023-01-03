package com.hackerton.jureumuing.ui.main.registeter

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.hackerton.jureumuing.databinding.ActivityRegisterMissionBinding
import com.hackerton.jureumuing.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterMissionActivity :
    BaseActivity<ActivityRegisterMissionBinding>(ActivityRegisterMissionBinding::inflate) {

    private val viewModel by viewModels<RegisterMissionViewModel>()

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            try {
                uri?.apply { viewModel.setImage(uri) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    override fun initAfterBinding() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initButton()
    }

    private fun initButton() {
        with(binding) {
            btnBack.setOnClickListener { finish() }
            ivThumbnail.setOnClickListener { getContent.launch("image/*") }
            fabRegister.setOnClickListener { viewModel!!.registerMission() }
        }
    }
}