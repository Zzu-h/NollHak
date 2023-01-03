package com.hackerton.jureumuing.ui.main.chart

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hackerton.jureumuing.databinding.FragmentChartBinding
import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.ui.BaseActivity
import com.hackerton.jureumuing.ui.BaseFragment
import com.hackerton.jureumuing.ui.detail.BoardActivity
import com.hackerton.jureumuing.ui.main.chart.adapter.MissionCandidateRVAdapter
import com.hackerton.jureumuing.ui.main.registeter.RegisterMissionActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CandidateFragment : BaseFragment<FragmentChartBinding>(FragmentChartBinding::inflate) {

    private val viewModel by viewModels<CandidateViewModel>()
    private lateinit var rvAdapter: MissionCandidateRVAdapter
    private lateinit var listener: MissionCandidateRVAdapter.ClickListener

    override fun initAfterBinding() {
        initListener()
        initRecyclerView()
        initObserver()
        initButton()
    }

    private fun initButton() {
        binding.fabRegister.setOnClickListener {
            startActivity(Intent(requireContext(), RegisterMissionActivity::class.java))
        }
    }

    private fun initListener() {
        listener = object : MissionCandidateRVAdapter.ClickListener {
            override fun onItemClick(item: Candidate) {}
        }
    }

    private fun initObserver() {
        with(viewModel) {
            showMissionList.onEach { rvAdapter.submitList(it) }
                .launchIn(this@CandidateFragment.lifecycleScope)
        }
    }

    private fun initRecyclerView() {
        rvAdapter = MissionCandidateRVAdapter(listener)
        binding.rvMission.adapter = rvAdapter
    }

    private fun startActivity(item: Candidate) {
        val intent = Intent(requireContext(), BoardActivity::class.java)
        (requireActivity() as BaseActivity<*>).startNextActivityWithIntent(intent)
    }
}