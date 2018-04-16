package com.alqasrawi.pegb.forecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alqasrawi.pegb.R

class ForecastActivity : AppCompatActivity(), ForecastContract.View {

    lateinit var forecastPresenter : ForecastPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)
        forecastPresenter = ForecastPresenter(this)
        forecastPresenter.getWeatherInfo()
    }

    override fun showWeatherInfo() {
    }

    override fun showHideLoadingView(show: Boolean) {
    }

    override fun showErrorMessage() {
    }

}