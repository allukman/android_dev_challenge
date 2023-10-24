package com.karsatech.casestudy3.domain.model

object PortfolioData {
    val listPortfolio = listOf(
        PortfolioModel(
            "Tarik Tunai",
            "55",
            arrayListOf(
                PortfolioItem("21/01/2023", 100000),
                PortfolioItem("20/01/2023", 50000),
                PortfolioItem("19/01/2023", 100000),
            )
        ),
        PortfolioModel(
            "QRIS Payment",
            "31",
            arrayListOf(
                PortfolioItem("21/01/2023", 159000),
                PortfolioItem("20/01/2023", 35000),
                PortfolioItem("19/01/2023", 1500),
            )
        ),
        PortfolioModel(
            "Topup Gopay",
            "7.7",
            arrayListOf(
                PortfolioItem("21/01/2023", 200000),
                PortfolioItem("20/01/2023", 195000),
                PortfolioItem("19/01/2023", 5000000),
            )
        ),
        PortfolioModel(
            "Lainnya",
            "6.3",
            arrayListOf(
                PortfolioItem("21/01/2023", 1000000),
                PortfolioItem("20/01/2023", 500000),
                PortfolioItem("19/01/2023", 100000),
            )
        )
    )
}