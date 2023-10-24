package com.karsatech.casestudy2.core.di

import com.karsatech.casestudy2.core.domain.repository.IPromoRepository
import com.karsatech.casestudy2.core.domain.repository.PromoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepositoryPromo(promoRepository: PromoRepository): IPromoRepository
}