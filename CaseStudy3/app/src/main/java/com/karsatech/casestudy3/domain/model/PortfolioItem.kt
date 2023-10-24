package com.karsatech.casestudy3.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortfolioItem(
    @SerializedName("trx_date") var trxDate : String,
    @SerializedName("nominal") var nominal : Int
) : Parcelable
