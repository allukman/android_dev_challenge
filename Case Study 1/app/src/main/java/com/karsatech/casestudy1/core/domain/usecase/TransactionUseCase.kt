package com.karsatech.casestudy1.core.domain.usecase

import com.karsatech.casestudy1.core.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionUseCase {

    fun getAllTransactionHistory(): Flow<List<Transaction>>
    fun addNewTransaction(newTransaction: Transaction)

}