package com.hackerton.jureumuing.ui.detail

import android.content.Intent
import androidx.activity.viewModels
import com.hackerton.jureumuing.databinding.ActivityBoardBinding
import com.hackerton.jureumuing.domain.model.Challenge
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.BaseActivity
import com.hackerton.jureumuing.ui.detail.adapter.ChallengeRVAdapter
import com.hackerton.jureumuing.ui.main.board.MissionViewModel

class BoardActivity : BaseActivity<ActivityBoardBinding>(ActivityBoardBinding::inflate) {

    private val mission: Mission by lazy { intent.getParcelableExtra("mission")!! }

    private val viewModel by viewModels<MissionViewModel>()
    private lateinit var rvAdapter: ChallengeRVAdapter
    private lateinit var listener: ChallengeRVAdapter.ClickListener

    override fun initAfterBinding() {
        binding.item = mission
        initListener()
        initRecyclerView()
        initButton()
    }

    private fun initButton() {
        binding.btnBack.setOnClickListener { finish() }
    }

    private fun initListener() {
        listener = object : ChallengeRVAdapter.ClickListener {
            override fun onItemClick(item: Challenge) {
                showToast("${item}")
                //startActivity(item)
            }
        }
    }

    private fun initRecyclerView() {
        rvAdapter = ChallengeRVAdapter(listener)
        binding.rvBoardList.adapter = rvAdapter
        rvAdapter.submitList(mission.challengeList)
    }

    private fun startActivity(item: Challenge) {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("challenge", item)
        startNextActivityWithIntent(intent)
    }
}