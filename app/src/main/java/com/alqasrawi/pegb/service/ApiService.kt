package com.alqasrawi.pegb.service

import com.alqasrawi.pegb.Config.API_BASE_URL
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object ApiService {

    var api: Api

    init {
        var retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit!!.create<Api>(Api::class.java!!)
    }
}