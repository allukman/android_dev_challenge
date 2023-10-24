package com.karsatech.casestudy1.features.transaction

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.karsatech.casestudy1.R
import com.karsatech.casestudy1.core.domain.model.Transaction
import com.karsatech.casestudy1.core.factory.BalanceViewModelFactory
import com.karsatech.casestudy1.core.util.Helper.addThousandSeparator
import com.karsatech.casestudy1.core.util.datastore.BalancePreferences
import com.karsatech.casestudy1.core.util.datastore.dataStore
import com.karsatech.casestudy1.databinding.ActivityTransactionBinding
import com.karsatech.casestudy1.features.BalanceViewModel
import com.karsatech.casestudy1.features.history.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TransactionActivity : AppCompatActivity() {

    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var binding: ActivityTransactionBinding
    private var balance = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailTransaction = intent.getStringExtra("DETAIL_TRANSACTION")
        setData(detailTransaction!!)
    }

    private fun setData(data: String) {
        val pref = BalancePreferences.getInstance(application.dataStore)
        val balanceViewModel = ViewModelProvider(this, BalanceViewModelFactory(pref))[BalanceViewModel::class.java]

        balanceViewModel.getCurrentBalance().observe(this) { currentBalance: Int ->
            balance = currentBalance
            binding.balance.text = getString(R.string.label_nominal_balance_text, balance.addThousandSeparator())
        }

        val barcodePart = data.split('.')

        val bankName = barcodePart[0]
        val idTransaction = barcodePart[1]
        val userName = barcodePart[2]
        val nominal = barcodePart[3]

        binding.nameReceiver.text = getString(R.string.label_name_receiver_text, userName)
        binding.nominalTransfer.text =
            getString(R.string.label_nominal_balance_text, nominal.toInt().addThousandSeparator())
        binding.bankTujuan.text = bankName

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val transaction = Transaction(
            idTransaction = idTransaction,
            userName = userName,
            userBank = bankName,
            userNominalTransfer = nominal
        )

        binding.btnSubmit.setOnClickListener {
            balanceViewModel.setCurrentBalance(balance - nominal.toInt())
            historyViewModel.addNewTransaction(transaction)
            val intent = Intent(this, SuccessTransactionActivity::class.java)
            intent.putExtra("DETAIL_TRANSACTION", data)
            startActivity(intent)
        }
    }
}