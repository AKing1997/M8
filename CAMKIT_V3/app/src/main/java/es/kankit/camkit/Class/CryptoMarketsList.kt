package es.kankit.camkit.Interficie

class CoinMarketsList(
    val markets: List<CryptoGecko>,
    val total: Int,
    val perPage: Int,
    val nextPage: Int?,
    val previousPage: Int?
)