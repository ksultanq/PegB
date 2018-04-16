package com.alqasrawi.pegb.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country (
        @SerializedName("ID") val id: String,
        @SerializedName("LocalizedName") val localizedName: String,
        @SerializedName("EnglishName") val englishName: String
) : Parcelable