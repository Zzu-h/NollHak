package com.hackerton.jureumuing.ui.main.challenge.upload

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hackerton.jureumuing.R
import com.hackerton.jureumuing.databinding.FragmentChallengeUploadBinding
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChallengeUploadFragment :
    BaseFragment<FragmentChallengeUploadBinding>(FragmentChallengeUploadBinding::inflate) {

    private val args: ChallengeUploadFragmentArgs by navArgs()
    private val mission: Mission by lazy { args.item }

    private val viewModel by viewModels<ChallengeUploadViewModel>()

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
            btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_fragment_challenge_upload_to_fragment_challenge_list)
            }
            ivThumbnail.setOnClickListener { getContent.launch("image/*") }
        }
    }
}