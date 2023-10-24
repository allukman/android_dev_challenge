package com.karsatech.casestudy1.features.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.karsatech.casestudy1.core.domain.model.Transaction
import com.karsatech.casestudy1.core.domain.usecase.TransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val transactionUseCase: TransactionUseCase) : ViewModel() {

    val transactionHistory = transactionUseCase.getAllTransactionHistory().asLiveData()

    fun addNewTransaction(newTransaction: Transaction) = transactionUseCase.addNewTransaction(newTransaction)

}