package com.alqasrawi.pegb.main

import com.alqasrawi.pegb.constants.Config.API_KEY
import com.alqasrawi.pegb.constants.Config.API_LANGUAGE
import com.alqasrawi.pegb.constants.Config.REGION_MEA
import com.alqasrawi.pegb.data.Country
import com.alqasrawi.pegb.service.ApiService
import com.alqasrawi.pegb.util.CollectionUtils.isNullOrEmpty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val mainView: MainContract.View) : MainContract.Presenter {

    var countries: List<Country>? = emptyList()
    val periods: List<Int> = listOf(1, 3, 7, 14)

    override fun getCountries() {
        showHideLoadingView(true)
        ApiService
                .api
                .getCountries(REGION_MEA, API_KEY, API_LANGUAGE)
                .enqueue(object: Callback<List<Country>> {
                    override fun onResponse(call: Call<List<Country>>?,
                                            response: Response<List<Country>>?) {
                        val countriesList = response?.body()
                        if (!isNullOrEmpty(countriesList)) {
                            mainView?.showCountries(countriesList!!)
                            countries = countriesList
                        } else {
                            mainView?.showErrorMessage()
                        }
                        showHideLoadingView(false)
                    }

                    override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                        showHideLoadingView(false)
                        mainView?.showErrorMessage()
                    }

                })
    }

    override fun showForecastInfo(countryPosition: Int, periodPosition: Int) {
        var country = countries?.get(countryPosition)
        var period = periods[periodPosition]
        country.let {
            mainView?.showForecastInfoScreen(it!!, period)
        }
    }

    private fun showHideLoadingView(show: Boolean) {
        mainView.showHideLoadingView(show)
    }

}