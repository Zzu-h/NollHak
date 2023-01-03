package com.hackerton.jureumuing.ui.main.challenge

import androidx.navigation.fragment.NavHostFragment
import com.hackerton.jureumuing.R
import com.hackerton.jureumuing.databinding.FragmentChallengeBinding
import com.hackerton.jureumuing.ui.BaseFragment

class ChallengeFragment :
    BaseFragment<FragmentChallengeBinding>(FragmentChallengeBinding::inflate) {

    override fun initAfterBinding() {
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.fcv_content)

        val navController = (navHostFragment as NavHostFragment).navController
    }
}