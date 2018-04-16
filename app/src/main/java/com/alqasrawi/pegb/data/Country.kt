package com.alqasrawi.pegb.data

import com.google.gson.annotations.SerializedName

data class Country(
        @SerializedName("ID") val id: String,
        @SerializedName("LocalizedName") val localizedName: String,
        @SerializedName("EnglishName") val englishName: String
)