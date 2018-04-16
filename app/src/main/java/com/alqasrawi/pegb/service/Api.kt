package com.alqasrawi.pegb.service

import com.alqasrawi.pegb.data.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/locations/v1/countries/{region}")
    fun getCountries(@Path("region") region: String,
                     @Query("apikey") apiKey: String,
                     @Query("language") language: String): Call<List<Country>>

}