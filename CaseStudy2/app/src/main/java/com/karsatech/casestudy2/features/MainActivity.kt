package com.karsatech.casestudy2.features

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.karsatech.casestudy2.R
import com.karsatech.casestudy2.core.data.Resource
import com.karsatech.casestudy2.core.data.remote.response.DataPromo
import com.karsatech.casestudy2.databinding.ActivityMainBinding
import com.karsatech.casestudy2.features.DetailActivity.Companion.DETAIL_PROMO
import com.karsatech.casestudy2.ui.adapter.PromoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var promoAdapter: PromoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeRecyclerViews()

        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.getPromo.observe(this) { promo ->
            when (promo) {
                is Resource.Loading -> showLoadingState(binding.progressBar)

                is Resource.Success -> {
                    hideLoadingState(binding.progressBar)
                    promo.data?.data?.let { setPromoData(it) }
                }

                is Resource.Error -> {
                    hideLoadingState(binding.progressBar)
                    showErrorState(binding.error, promo.message ?: getString(R.string.something_wrong))
                }
            }
        }
    }

    private fun showLoadingState(progressBar: ShimmerFrameLayout) {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoadingState(progressBar: ShimmerFrameLayout) {
        progressBar.visibility = View.GONE
    }

    private fun showErrorState(errorTextView: TextView, errorMessage: String) {
        errorTextView.visibility = View.VISIBLE
        errorTextView.text = errorMessage
    }

    private fun initializeRecyclerViews() {
        binding.rvPromo.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            promoAdapter = PromoAdapter()
            adapter = promoAdapter
        }
    }

    private fun setPromoData(data: List<DataPromo?>) {
        promoAdapter.submitList(data)

        promoAdapter.setOnItemClickCallback(object : PromoAdapter.ActionAdapter {
            override fun onItemClick(data: DataPromo) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DETAIL_PROMO, data)
                startActivity(intent)
            }
        })
    }
}