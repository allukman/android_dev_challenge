package com.karsatech.casestudy1.core.di

import com.karsatech.casestudy1.core.domain.repository.ITransactionRepository
import com.karsatech.casestudy1.core.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepositoryTransaction(transactionRepository: TransactionRepository): ITransactionRepository

}