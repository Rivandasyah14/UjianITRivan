package com.rivan.ujianitrivan.network

import com.rivan.ujianitrivan.model.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceClient {
    @GET("filter.php?c=Seafood")
    fun getSeafood(
//        @Query("api_key") api_key: String
    ) : Call<MealsResponse>

    @GET("filter.php?c=Dessert")
    fun getDessert(
//        @Query("api_key") api_key: String
    ) : Call<MealsResponse>
}