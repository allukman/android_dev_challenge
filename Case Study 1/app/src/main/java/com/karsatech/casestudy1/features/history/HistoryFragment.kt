package com.karsatech.casestudy1.features.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karsatech.casestudy1.core.data.local.adapter.HistoryTransactionAdapter
import com.karsatech.casestudy1.core.domain.model.Transaction
import com.karsatech.casestudy1.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var historyTransactionAdapter:HistoryTransactionAdapter

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerViews()

        historyViewModel.transactionHistory.observe(viewLifecycleOwner) { listTransaction ->
            if (listTransaction.isEmpty()) {
                showEmpty(true)
            } else {
                showEmpty(false)
                setRecyclerviewData(listTransaction)
            }
        }
    }

    private fun showEmpty(show: Boolean) {
        binding.lottieEmpty.visibility = if (show) View.VISIBLE else View.GONE
        binding.tvEmpty.visibility = if (show) View.VISIBLE else View.GONE
        binding.rvHistoryTransaction.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun setRecyclerviewData(data: List<Transaction>) {
        historyTransactionAdapter.submitList(data)
    }

    private fun initializeRecyclerViews() {
        binding.rvHistoryTransaction.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            historyTransactionAdapter = HistoryTransactionAdapter()
            adapter = historyTransactionAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}