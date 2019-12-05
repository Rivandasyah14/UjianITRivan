package com.rivan.ujianitrivan.pattern

import android.annotation.SuppressLint
import com.rivan.ujianitrivan.base.BasePresenter
import com.rivan.ujianitrivan.model.MealsResponse
import com.rivan.ujianitrivan.network.Http
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DessertPresenter(var mealsView: DessertView? = null): BasePresenter<DessertView>{

    @SuppressLint("CheckResult")
    fun getDataDessert() {
        Http.retrofit.getDessert()
            .enqueue(object : Callback<MealsResponse> {
                override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                    mealsView?.showDataDessert(response.body()?.meals!!)
                }

                override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                    mealsView?.error(t.message)
                }
            })
    }

    override fun onAttach(view: DessertView) {
        mealsView = view

    }

    override fun onDetach() {
        mealsView = null
    }
}