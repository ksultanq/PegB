package com.alqasrawi.pegb.main

import com.alqasrawi.pegb.data.Country

interface MainContract {

    interface Presenter {

        fun getCountries()

        fun showCountryWeatherInfo(countryPosition: Int, periodPosition: Int)

    }

    interface View {

        fun showCountries(countries: List<Country>)

        fun showWeatherInfoScreen(country: Country, position: Int)

        fun showHideLoadingView(show: Boolean)

        fun showErrorMessage()

    }

}

