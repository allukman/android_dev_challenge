package com.karsatech.casestudy1.core.domain.repository

import com.karsatech.casestudy1.core.data.local.LocalDataSource
import com.karsatech.casestudy1.core.domain.model.Transaction
import com.karsatech.casestudy1.core.util.AppExecutors
import com.karsatech.casestudy1.core.util.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val localDataSource: LocalDataSource
) : ITransactionRepository {

    override fun getAllTransactionHistory(): Flow<List<Transaction>> {
        return localDataSource.getAllTransactionHistory().map {
            DataMapper.mapTransactionEntitiesToDomain(it)
        }
    }

    override fun addNewTransaction(newTransaction: Transaction) {
        val transactionEntity = DataMapper.mapDomainToEntityTransaction(newTransaction)
        appExecutors.diskIO().execute { localDataSource.insertNewTransaction(transactionEntity) }
    }
}