package com.karsatech.casestudy1.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Transaction (
    val idTransaction: String,
    val userName: String,
    val userBank: String,
    val userNominalTransfer: String,
) : Parcelable