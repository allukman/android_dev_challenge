package com.karsatech.casestudy1.features.transaction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.karsatech.casestudy1.MainActivity
import com.karsatech.casestudy1.R
import com.karsatech.casestudy1.core.util.Helper.addThousandSeparator
import com.karsatech.casestudy1.databinding.ActivitySuccessTransactionBinding

class SuccessTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivitySuccessTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailTransaction = intent.getStringExtra("DETAIL_TRANSACTION")
        setData(detailTransaction!!)
    }

    private fun setData(data: String) {
        val barcodePart = data.split('.')

        val bankName = barcodePart[0]
        val idTransaction = barcodePart[1]
        val userName = barcodePart[2]
        val nominal = barcodePart[3]

        binding.labelNameReceiver.text = getString(R.string.label_name_receiver_text, userName)
        binding.labelBank.text = getString(R.string.label_bank_text, bankName, idTransaction)
        binding.labelNominalBalance.text =
            getString(R.string.label_nominal_balance_text, nominal.toInt().addThousandSeparator())
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}