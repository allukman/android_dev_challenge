package com.karsatech.casestudy2.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.karsatech.casestudy2.core.domain.usecase.PromoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(promoUseCase: PromoUseCase) : ViewModel() {

    val getPromo = promoUseCase.getPromo().asLiveData()

}