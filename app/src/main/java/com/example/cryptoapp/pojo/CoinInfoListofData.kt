package com.example.cryptoapp.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class CoinInfoListofData (
    @SerializedName("Data")
    @Expose
     val data: List<Datum>? = null
)