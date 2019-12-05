package com.rivan.ujianitrivan.pattern

import android.annotation.SuppressLint
import com.rivan.ujianitrivan.base.BasePresenter
import com.rivan.ujianitrivan.model.MealsItem
import com.rivan.ujianitrivan.model.MealsResponse
import com.rivan.ujianitrivan.network.Http
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeafoodPresenter(var mealsView: SeafoodView? = null) :
    BasePresenter<SeafoodView> {

    @SuppressLint("CheckResult")
    fun getDataSeafood() {
        Http.retrofit.getSeafood()
            .enqueue(object : Callback<MealsResponse> {
                override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                    mealsView?.showDataMeals(response.body()?.meals!!)
                }

                override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                    mealsView?.error(t.message)
                }
            })
    }

    override fun onAttach(view: SeafoodView) {
        mealsView = view
    }

    override fun onDetach() {
        mealsView = null
    }
}