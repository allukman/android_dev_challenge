package com.karsatech.casestudy2.core.domain.usecase

import com.karsatech.casestudy2.core.data.Resource
import com.karsatech.casestudy2.core.data.remote.response.PromoResponse
import kotlinx.coroutines.flow.Flow

interface PromoUseCase {

    fun getPromo() : Flow<Resource<PromoResponse>>

}