package com.alqasrawi.pegb.main

import com.alqasrawi.pegb.base.BaseView
import com.alqasrawi.pegb.data.Country

interface MainContract {

    interface Presenter {

        fun getCountries()

        fun showForecastInfo(countryPosition: Int, periodPosition: Int)

    }

    interface View : BaseView {

        fun showCountries(countries: List<Country>)

        fun showForecastInfoScreen(country: Country, position: Int)

    }

}

