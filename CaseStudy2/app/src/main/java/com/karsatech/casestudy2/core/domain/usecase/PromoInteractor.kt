package com.karsatech.casestudy2.core.domain.usecase

import com.karsatech.casestudy2.core.domain.repository.PromoRepository
import javax.inject.Inject

class PromoInteractor @Inject constructor(private val promoRepository: PromoRepository): PromoUseCase {

    override fun getPromo() = promoRepository.getPromo()
}