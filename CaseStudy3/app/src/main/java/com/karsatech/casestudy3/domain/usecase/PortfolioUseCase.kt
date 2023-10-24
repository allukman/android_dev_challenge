package com.karsatech.casestudy3.domain.usecase

import com.karsatech.casestudy3.domain.model.PortfolioData
import com.karsatech.casestudy3.domain.model.PortfolioModel

class PortfolioUseCase {
    fun getPortfolioList(): List<PortfolioModel> {
        return PortfolioData.listPortfolio
    }
}