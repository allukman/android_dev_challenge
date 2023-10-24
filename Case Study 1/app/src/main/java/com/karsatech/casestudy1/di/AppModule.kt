package com.karsatech.casestudy1.di

import com.karsatech.casestudy1.core.domain.usecase.TransactionInteractor
import com.karsatech.casestudy1.core.domain.usecase.TransactionUseCase
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
    abstract fun provideTransactionUseCase(transactionInteractor: TransactionInteractor): TransactionUseCase

}
