package com.karsatech.casestudy1.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_history")
data class TransactionEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_transaction_history")
    var idTransactionHistory: Int = 0,

    @ColumnInfo(name = "id_transaction")
    var idTransaction: String,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "user_bank")
    var userBank: String,

    @ColumnInfo(name = "user_nominal_transfer")
    var userNominalTransfer: String,

)