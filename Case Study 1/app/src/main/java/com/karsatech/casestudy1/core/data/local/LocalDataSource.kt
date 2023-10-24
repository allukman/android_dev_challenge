package com.karsatech.casestudy1.core.data.local

import com.karsatech.casestudy1.core.data.local.entity.TransactionEntity
import com.karsatech.casestudy1.core.data.local.room.TransactionDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val transactionDao: TransactionDao
) {

    fun getAllTransactionHistory() :Flow<List<TransactionEntity>> = transactionDao.getAllTransactionHistory()

    fun insertNewTransaction(transaction: TransactionEntity) {
        transactionDao.insertNewTransaction(transaction)
    }

}