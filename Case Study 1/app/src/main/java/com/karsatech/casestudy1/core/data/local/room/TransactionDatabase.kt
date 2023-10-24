package com.karsatech.casestudy1.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karsatech.casestudy1.core.data.local.entity.TransactionEntity

@Database(entities = [TransactionEntity::class], version = 1, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun transactionDao() :TransactionDao

}