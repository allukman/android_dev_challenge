package com.karsatech.casestudy3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karsatech.casestudy3.databinding.ActivityHistoryBinding
import com.karsatech.casestudy3.domain.model.PortfolioItem
import com.karsatech.casestudy3.domain.model.PortfolioModel

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var data: PortfolioModel
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = intent.getParcelableExtra<PortfolioModel>("portfolioData") as PortfolioModel

        initializeRecyclerViews()
        setRecyclerviewData(data.data)
    }

    private fun setRecyclerviewData(data: List<PortfolioItem>) {
        historyAdapter.submitList(data)
    }

    private fun initializeRecyclerViews() {
        binding.rvHistoryTransaction.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity, RecyclerView.VERTICAL, false)
            historyAdapter = HistoryAdapter()
            adapter = historyAdapter
        }
    }
}