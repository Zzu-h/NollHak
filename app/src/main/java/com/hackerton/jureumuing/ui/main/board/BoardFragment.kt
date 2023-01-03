package com.hackerton.jureumuing.ui.main.board

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hackerton.jureumuing.databinding.FragmentBoardBinding
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.BaseActivity
import com.hackerton.jureumuing.ui.BaseFragment
import com.hackerton.jureumuing.ui.detail.BoardActivity
import com.hackerton.jureumuing.ui.main.board.adapter.MissionSummaryRVAdapter
import com.hackerton.jureumuing.ui.main.registeter.RegisterMissionActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class BoardFragment : BaseFragment<FragmentBoardBinding>(FragmentBoardBinding::inflate) {

    private val viewModel by viewModels<MissionViewModel>()
    private lateinit var rvAdapter: MissionSummaryRVAdapter
    private lateinit var listener: MissionSummaryRVAdapter.ClickListener

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
        listener = object : MissionSummaryRVAdapter.ClickListener {
            override fun onItemClick(item: Mission) {
                startActivity(item)
            }
        }
    }

    private fun initObserver() {
        with(viewModel) {
            showMissionList.onEach { rvAdapter.submitList(it) }
                .launchIn(this@BoardFragment.lifecycleScope)
        }
    }

    private fun initRecyclerView() {
        rvAdapter = MissionSummaryRVAdapter(listener)
        binding.rvMission.adapter = rvAdapter
    }

    private fun startActivity(item: Mission) {
        val intent = Intent(requireContext(), BoardActivity::class.java)
        intent.putExtra("mission", item)
        (requireActivity() as BaseActivity<*>).startNextActivityWithIntent(intent)
    }

}