package com.karsatech.casestudy2.core.data.remote.network

import com.karsatech.casestudy2.core.data.remote.response.PromoResponse
import retrofit2.http.GET

interface PromoService {

    @GET("api/users?page=1")
    suspend fun getPromo() : PromoResponse

}