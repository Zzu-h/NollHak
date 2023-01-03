package com.hackerton.jureumuing.ui.main.challenge.list

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hackerton.jureumuing.databinding.FragmentChallengeListBinding
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.BaseFragment
import com.hackerton.jureumuing.ui.main.challenge.list.adapter.MissionRVAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ChallengeListFragment :
    BaseFragment<FragmentChallengeListBinding>(FragmentChallengeListBinding::inflate) {

    private val viewModel by viewModels<ChallengeListViewModel>()

    private val spinnerList = listOf("최신순", "오래된 순")

    private lateinit var rvAdapter: MissionRVAdapter
    private lateinit var listener: MissionRVAdapter.ClickListener

    override fun initAfterBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initListener()
        initRecyclerView()
        initObserver()
        initSpinner()
    }

    private fun initListener() {
        listener = object : MissionRVAdapter.ClickListener {
            override fun onItemClick(item: Mission) {
                val action = ChallengeListFragmentDirections
                    .actionFragmentChallengeListToFragmentChallengeUpload(item)
                findNavController().navigate(action)
            }
        }
    }

    private fun initObserver() {
        with(viewModel) {
            showMissionList.onEach { rvAdapter.submitList(it) }
                .launchIn(this@ChallengeListFragment.lifecycleScope)
        }
    }

    private fun initRecyclerView() {
        rvAdapter = MissionRVAdapter(listener)
        binding.rvMission.adapter = rvAdapter
    }

    private fun initSpinner() {
        val adapter =
            ArrayAdapter(requireContext(), R.layout.simple_spinner_dropdown_item, spinnerList)
        binding.spinnerFilter.adapter = adapter
        binding.spinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) = Unit
        }
    }
}