package es.kankit.camkit.Interficie

import es.kankit.camkit.Class.SearchList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoGeckoAPI {
    @GET("coins/markets?vs_currency=eur&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    fun getCryptoList(@Query("per_page") per_page: String?, @Query("vs_currency") vs_currency: String?, @Query("page") page: String?):
            Call<ArrayList<CryptoGecko>?>
    @GET("search?query=bitcoin")
    fun getCryptoSearchList(@Query("query") query: String?):
            Call<SearchList?>
    @GET("coins/markets?vs_currency=eur&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    fun getCryptoListByIds(@Query("ids") ids: String?):
            Call<ArrayList<CryptoGecko>?>
}