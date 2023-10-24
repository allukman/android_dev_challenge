package com.karsatech.casestudy1.core.domain.usecase

import com.karsatech.casestudy1.core.domain.model.Transaction
import com.karsatech.casestudy1.core.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionInteractor @Inject constructor(private val transactionRepository: TransactionRepository) :
    TransactionUseCase {
    override fun getAllTransactionHistory() = transactionRepository.getAllTransactionHistory()

    override fun addNewTransaction(newTransaction: Transaction) = transactionRepository.addNewTransaction(newTransaction)
}