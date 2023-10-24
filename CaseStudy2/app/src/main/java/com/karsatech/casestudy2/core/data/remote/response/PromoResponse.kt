package com.karsatech.casestudy2.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoResponse(
	val perPage: Int? = null,
	val total: Int? = null,
	val data: List<DataPromo?>? = null,
	val page: Int? = null,
	val totalPages: Int? = null,
	val support: Support? = null
) : Parcelable

@Parcelize
data class Support(
	val text: String? = null,
	val url: String? = null
) : Parcelable

@Parcelize
data class DataPromo(
	@SerializedName("last_name")
	val lastName: String? = null,
	val id: Int? = null,
	val avatar: String? = null,
	@SerializedName("first_name")
	val firstName: String? = null,
	val email: String? = null
) : Parcelable
