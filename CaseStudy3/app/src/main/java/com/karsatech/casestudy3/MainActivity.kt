package com.karsatech.casestudy3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.MPPointF
import com.karsatech.casestudy3.databinding.ActivityMainBinding
import com.karsatech.casestudy3.domain.model.PortfolioData
import com.karsatech.casestudy3.domain.model.PortfolioModel
import com.karsatech.casestudy3.domain.usecase.PortfolioUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val portfolioUseCase = PortfolioUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val portfolioList = portfolioUseCase.getPortfolioList()

        setupPieChart(portfolioList)
    }

    private fun setupPieChart(portfolioList: List<PortfolioModel>) {
        val pieChart = binding.pieChart

        with(pieChart) {
            // Chart configuration
            setUsePercentValues(true)
            description.isEnabled = false
            setExtraOffsets(5f, 10f, 5f, 5f)
            dragDecelerationFrictionCoef = 0.95f
            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            setTransparentCircleColor(Color.WHITE)
            setTransparentCircleAlpha(255)

            holeRadius = 72f
            transparentCircleRadius = 72f

            setDrawCenterText(true)
            rotationAngle = 0f
            isRotationEnabled = true
            isHighlightPerTapEnabled = true
            animateY(1400, Easing.EaseInOutQuad)
            legend.isEnabled = false
            setEntryLabelColor(Color.WHITE)
            setEntryLabelTextSize(12f)

            // Data
            val entries = portfolioList.map { PieEntry(it.percentage.toFloat()) }
            val dataSet = PieDataSet(entries, "Portfolio Statistic")
            dataSet.setDrawIcons(false)

            dataSet.sliceSpace = 3f
            dataSet.iconsOffset = MPPointF(0f, 40f)
            dataSet.selectionShift = 5f

            // Hide the values (percentages)
            dataSet.setDrawValues(false)

            // Colors
            val colors = listOf(
                R.color.green,
                R.color.yellow,
                R.color.blue,
                R.color.red
            ).map { ContextCompat.getColor(this@MainActivity, it) }
            dataSet.colors = colors

            val data = PieData(dataSet)
            pieChart.data = data

            highlightValues(null)

            invalidate()
        }

        binding.pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                e?.let {
                    when (it.y) {
                        55f -> intentDetail(portfolioList[0])
                        31f -> intentDetail(portfolioList[1])
                        7.7f -> intentDetail(portfolioList[2])
                        6.3f -> intentDetail(portfolioList[3])
                    }
                }
            }

            override fun onNothingSelected() {
                // Do something when nothing is selected
            }
        })
    }


    private fun intentDetail(data: PortfolioModel) {
        val intent = Intent(this@MainActivity, HistoryActivity::class.java)
        intent.putExtra("portfolioData", data)
        startActivity(intent)
    }
}