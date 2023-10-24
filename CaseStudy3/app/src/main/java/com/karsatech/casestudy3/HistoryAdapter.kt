package com.karsatech.casestudy3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karsatech.casestudy3.databinding.ItemHistoryBinding
import com.karsatech.casestudy3.domain.model.PortfolioItem
import com.karsatech.casestudy3.util.Helper.addThousandSeparator
import com.karsatech.casestudy3.util.Helper.formatDate

class HistoryAdapter : ListAdapter<PortfolioItem, HistoryAdapter.RecyclerViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PortfolioItem>() {
            override fun areItemsTheSame(
                oldItem: PortfolioItem,
                newItem: PortfolioItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PortfolioItem,
                newItem: PortfolioItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val bind = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return RecyclerViewHolder(bind)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }


    inner class RecyclerViewHolder(private val bind: ItemHistoryBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun bind(data: PortfolioItem) {
            with(bind) {
                bind.date.text = formatDate(data.trxDate)
                bind.nominal.text = "RP. " + data.nominal.addThousandSeparator()
            }
        }
    }
}