package com.alqasrawi.pegb.forecast

import com.alqasrawi.pegb.base.BaseView

interface ForecastContract {

    interface Presenter {

        fun getWeatherInfo()

    }

    interface View : BaseView{

        fun showWeatherInfo()

    }

}