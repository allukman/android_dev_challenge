package com.karsatech.casestudy2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.karsatech.casestudy2.core.data.remote.response.DataPromo
import com.karsatech.casestudy2.databinding.ItemPromoBinding

class PromoAdapter :ListAdapter<DataPromo, PromoAdapter.RecyclerViewHolder>(DIFF_CALLBACK) {

    private lateinit var actionAdapter: ActionAdapter

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataPromo>() {
            override fun areItemsTheSame(
                oldItem: DataPromo,
                newItem: DataPromo
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DataPromo,
                newItem: DataPromo
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val bind = ItemPromoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return RecyclerViewHolder(bind)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOnItemClickCallback(onItemClickCallback: ActionAdapter) {
        this.actionAdapter = onItemClickCallback
    }

    inner class RecyclerViewHolder(private val bind: ItemPromoBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun bind(data: DataPromo) {
            with(bind) {
                name.text = data.firstName + " " + data.lastName
                email.text = data.email

                itemView.setOnClickListener {
                    actionAdapter.onItemClick(data)
                }

            }
        }
    }

    interface ActionAdapter {
        fun onItemClick(data: DataPromo)
    }
}