package com.karsatech.casestudy1.core.data.local.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karsatech.casestudy1.core.domain.model.Transaction
import com.karsatech.casestudy1.core.util.Helper.addThousandSeparator
import com.karsatech.casestudy1.databinding.ItemListTransactionBinding

class HistoryTransactionAdapter : ListAdapter<Transaction, HistoryTransactionAdapter.RecyclerViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Transaction>() {
            override fun areItemsTheSame(
                oldItem: Transaction,
                newItem: Transaction
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Transaction,
                newItem: Transaction
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val bind = ItemListTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return RecyclerViewHolder(bind)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }


    inner class RecyclerViewHolder(private val bind: ItemListTransactionBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun bind(data: Transaction) {
            with(bind) {
                name.text = data.userName
                idTransaction.text = data.idTransaction
                labelNominal.text = "- RP. " + data.userNominalTransfer.toInt().addThousandSeparator()
            }
        }
    }
}