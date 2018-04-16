package com.alqasrawi.pegb.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.OnItemSelected
import com.alqasrawi.pegb.R
import com.alqasrawi.pegb.adapter.CountriesAdapter
import com.alqasrawi.pegb.data.Country
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mainPresenter : MainPresenter
    var selectedCountryPosition = 0
    var selectedPeriodPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        mainPresenter = MainPresenter(this)
        mainPresenter.getCountries()
    }

    override fun showCountries(countries: List<Country>) {
        showHideLoadingView(false)
        infoSelectionLayout.visibility = VISIBLE
        countriesSpinner.adapter = CountriesAdapter(this, 0, countries)
        periodSpinner.adapter = ArrayAdapter.createFromResource(this,
                R.array.periods_array, R.layout.spinner_item)
        countriesSpinner.setSelection(0)
    }

    override fun showErrorMessage() {
        infoSelectionLayout.visibility = GONE
        errorText.visibility = VISIBLE
        errorText.text = getString(R.string.general_error_message)
    }

    override fun showHideLoadingView(show: Boolean) {
        if (show) {
            progressBar.visibility = VISIBLE
        } else {
            progressBar.visibility = GONE
        }
    }

    override fun showWeatherInfoScreen(country: Country, period: Int) {
        // TODO start WeatherInfoActivity
    }

    @OnClick(R.id.showInfoButton)
    fun onInfoButtonClicked() {
        mainPresenter.showCountryWeatherInfo(selectedCountryPosition, selectedPeriodPosition)
    }

    @OnItemSelected(R.id.countriesSpinner)
    fun onCountrySelected(position: Int) {
        selectedCountryPosition = position
    }

    @OnItemSelected(R.id.periodSpinner)
    fun onPeriodSelected(position: Int) {
        selectedPeriodPosition = position
    }

}
