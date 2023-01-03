package com.hackerton.jureumuing.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.hackerton.jureumuing.R
import com.hackerton.jureumuing.databinding.ActivityMainBinding
import com.hackerton.jureumuing.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initAfterBinding() {
        buttonSetting()
    }

    private fun buttonSetting() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_content) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragment_challenge -> {
                    binding.tvMenuTitle.text = getString(R.string.app_name)
                    binding.fabBattle.isSelected = true
                }
                R.id.fragment_chart -> {
                    binding.tvMenuTitle.text = getString(R.string.fragment_chart)
                    binding.fabBattle.isSelected = false
                }
                R.id.fragment_board -> {
                    binding.tvMenuTitle.text = getString(R.string.fragment_board)
                    binding.fabBattle.isSelected = false
                }
                R.id.fragment_profile -> {
                    binding.tvMenuTitle.text = "마이프로필"
                    binding.fabBattle.isSelected = false
                }
                else -> {
                    binding.tvMenuTitle.text = getString(R.string.app_name)
                    binding.fabBattle.isSelected = false
                }
            }
        }

        binding.bnvMain.setupWithNavController(navController)

        binding.fabBattle.setOnClickListener {
            binding.bnvMain.selectedItemId = R.id.fragment_challenge
        }
    }
}