package com.karsatech.casestudy2.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.karsatech.casestudy2.R
import com.karsatech.casestudy2.core.data.remote.response.DataPromo
import com.karsatech.casestudy2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var data: DataPromo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = intent.getParcelableExtra<DataPromo>(DETAIL_PROMO) as DataPromo

        setData(data)

    }

    private fun setData(data: DataPromo) {
        Glide.with(this)
            .load(data.avatar)
            .into(binding.imageProfile)

        binding.name.text = data.firstName + " " + data.lastName
        binding.email.text = data.email
    }

    companion object {
        const val DETAIL_PROMO = "DETAIL_PROMO"
    }
}