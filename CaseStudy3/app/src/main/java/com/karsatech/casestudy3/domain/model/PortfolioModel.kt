package com.karsatech.casestudy3.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortfolioModel(
    @SerializedName("label") var label: String,
    @SerializedName("percentage") var percentage: String,
    @SerializedName("data") var data: ArrayList<PortfolioItem>
) : Parcelable
