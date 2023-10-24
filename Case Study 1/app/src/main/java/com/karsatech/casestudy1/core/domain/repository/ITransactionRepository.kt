package com.karsatech.casestudy1.core.domain.repository

import com.karsatech.casestudy1.core.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface ITransactionRepository {
    fun getAllTransactionHistory(): Flow<List<Transaction>>
    fun addNewTransaction(newTransaction: Transaction)
}