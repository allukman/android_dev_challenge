package com.karsatech.casestudy1.core.di

import android.content.Context
import androidx.room.Room
import com.karsatech.casestudy1.core.data.local.room.TransactionDao
import com.karsatech.casestudy1.core.data.local.room.TransactionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TransactionDatabase = Room.databaseBuilder(
        context,
        TransactionDatabase::class.java, "Transaction.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTransactionDao(database: TransactionDatabase): TransactionDao = database.transactionDao()
}