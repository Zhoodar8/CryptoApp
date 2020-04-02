package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinInfoListofData
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERY_PARAM_LIMIT) limit:Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym:String = CURRENCY
    ): Single<CoinInfoListofData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERY_PARAM_FSYMS) fSyms: String,
        @Query(QUERY_PARAM_TSYMS) tSyms: String = CURRENCY

        ): Single<CoinPriceInfoRawData>

    companion object{
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val CURRENCY = "USD"
        private const val QUERY_PARAM_TSYMS = "tsyms"
        private const val QUERY_PARAM_FSYMS = "fsyms"
    }
}