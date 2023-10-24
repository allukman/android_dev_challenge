package com.karsatech.casestudy2.core.domain.repository

import android.util.Log
import com.karsatech.casestudy2.core.data.Resource
import com.karsatech.casestudy2.core.data.remote.network.PromoService
import com.karsatech.casestudy2.core.data.remote.response.PromoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PromoRepository @Inject constructor(private val promoService: PromoService): IPromoRepository {

    override fun getPromo(): Flow<Resource<PromoResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = promoService.getPromo()
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
                Log.e("PromoRepository", "getPromo : $e")
            }
        }.flowOn(Dispatchers.IO)
    }

}