package com.alqasrawi.pegb.adapter

import android.content.Context
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.alqasrawi.pegb.R
import com.alqasrawi.pegb.data.Country

class CountriesAdapter(context: Context?, resource: Int, val countries: List<Country>)
                        : ArrayAdapter<Country>(context, resource, countries) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView
                ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent,
                        false)
        val countryTextView = view.findViewById<TextView>(R.id.text)
        val countryName = countries?.get(position)?.englishName
        if (!isEmpty(countryName)) {
            countryTextView.text = countryName
        }
        return view;
    }

}