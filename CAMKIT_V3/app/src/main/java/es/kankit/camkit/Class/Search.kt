package es.kankit.camkit.Class


class SearchList (
    val coins: ArrayList<Coin>,
    val exchanges: ArrayList<Exchange>,
    val icos: ArrayList<Any?>,
    val categories: ArrayList<Category>,
    val nfts: ArrayList<Nft>
)

class Category (
    val id: Long,
    val name: String
)

class Coin (
    val id: String,
    val name: String,
    val api_symbol: String,
    val symbol: String,
    val market_cap_rank: Int,
    val thumb: String,
    val large: String
)

class Exchange (
    val id: String,
    val name: String,
    val marketType: String,
    val thumb: String,
    val large: String
)


class Nft (
    val id: String,
    val name: String,
    val symbol: String,
    val thumb: String
)
