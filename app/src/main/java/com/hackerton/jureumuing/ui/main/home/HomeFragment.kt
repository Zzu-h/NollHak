package com.hackerton.jureumuing.ui.main.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.PagerSnapHelper
import com.hackerton.jureumuing.databinding.FragmentHomeBinding
import com.hackerton.jureumuing.ui.BaseFragment
import com.hackerton.jureumuing.ui.main.home.adapter.AdapterRVAdapter
import com.hackerton.jureumuing.ui.main.home.adapter.RVImageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var rvImageAdapter: RVImageAdapter
    private var rvMissionAdapter: AdapterRVAdapter = AdapterRVAdapter()
    private var rvChallengeAdapter: AdapterRVAdapter = AdapterRVAdapter()
    private val viewModel by viewModels<HomeViewModel>()

    private val autoScrollDelayTime = 3000L
    private var job: Job? = null

    override fun initAfterBinding() {
        initObserver()
        initView()
        initRVAdapter()
    }

    private fun initObserver() {
        with(viewModel) {
            showMissionList.onEach {
                val tmpList = if (it.size > 5) it.subList(0, 5) else it
                rvMissionAdapter.submitList(tmpList.map { Pair(it._what, it.challengeList.size) })
            }.launchIn(this@HomeFragment.lifecycleScope)
            showChallengeList.onEach {
                val tmpList = if (it.size > 5) it.subList(0, 5) else it
                rvChallengeAdapter.submitList(tmpList.map { Pair(it.what, it.count) })
            }.launchIn(this@HomeFragment.lifecycleScope)
        }
    }

    private fun initView() {
        with(binding) {
            itemHotChallenge.tvTitle.text = "HOT 챌린지"
            itemHotMissions.tvTitle.text = "HOT 미션"
        }
    }

    private fun initRVAdapter() {
        rvImageAdapter = RVImageAdapter(dumpList)
        binding.rvPopularityContestImage.adapter = rvImageAdapter

        with(binding) {
            rvMissionAdapter = AdapterRVAdapter()
            rvChallengeAdapter = AdapterRVAdapter()
            itemHotMissions.rvOverviewContent.adapter = rvMissionAdapter
            itemHotChallenge.rvOverviewContent.adapter = rvChallengeAdapter
        }

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.rvPopularityContestImage)

        binding.ci2PopularityContestImage.attachToRecyclerView(
            binding.rvPopularityContestImage,
            pagerSnapHelper
        )
        rvImageAdapter.registerAdapterDataObserver(binding.ci2PopularityContestImage.adapterDataObserver)

        job = CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                delay(autoScrollDelayTime)
                val size = binding.rvPopularityContestImage.adapter!!.itemCount

                val currentIdx = pagerSnapHelper.findTargetSnapPosition(
                    binding.rvPopularityContestImage.layoutManager!!,
                    0,
                    0
                )
                binding.rvPopularityContestImage.smoothScrollToPosition((currentIdx + 1) % size)
            }
        }
    }

    override fun onDestroyView() {
        job?.cancel()
        super.onDestroyView()
    }

    private val dumpList = listOf(
        "https://img.freepik.com/free-vector/blue-technology-digital-banner-design_1017-32257.jpg?w=2000",
        "https://cdn.pixabay.com/photo/2015/10/29/14/38/web-1012467__340.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT94eF8n0RNHFzs2frZzUZDBSDZDBbX2I3bmQ&usqp=CAU"
    )
}