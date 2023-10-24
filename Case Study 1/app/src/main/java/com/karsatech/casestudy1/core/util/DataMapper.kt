package com.karsatech.casestudy1.core.util

import com.karsatech.casestudy1.core.data.local.entity.TransactionEntity
import com.karsatech.casestudy1.core.domain.model.Transaction

object DataMapper {
    fun mapTransactionEntitiesToDomain(input: List<TransactionEntity>): List<Transaction> =
        input.map {
            Transaction(
                idTransaction = it.idTransaction,
                userName = it.userName,
                userBank = it.userBank,
                userNominalTransfer = it.userNominalTransfer,
            )
        }

    fun mapDomainToEntityTransaction(input: Transaction) = TransactionEntity(
        idTransaction = input.idTransaction,
        userName = input.userName,
        userBank = input.userBank,
        userNominalTransfer = input.userNominalTransfer,
    )
}