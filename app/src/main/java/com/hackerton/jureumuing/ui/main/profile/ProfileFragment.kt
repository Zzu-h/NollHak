package com.hackerton.jureumuing.ui.main.profile

import com.hackerton.jureumuing.databinding.FragmentProfileBinding
import com.hackerton.jureumuing.ui.BaseActivity
import com.hackerton.jureumuing.ui.BaseFragment
import com.hackerton.jureumuing.ui.main.profile.editprofile.EditProfileActivity

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun initAfterBinding() {
        initView()
    }

    private fun initView() {
        initButton()
    }

    private fun initButton() {
        binding.itemProfile.layoutProfile.setOnClickListener {
            (requireActivity() as BaseActivity<*>).startNextActivity(EditProfileActivity::class.java)
        }
    }
}