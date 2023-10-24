package com.karsatech.casestudy2.di

import com.karsatech.casestudy2.core.domain.usecase.PromoInteractor
import com.karsatech.casestudy2.core.domain.usecase.PromoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun providePromoUseCase(promoInteractor: PromoInteractor): PromoUseCase

}