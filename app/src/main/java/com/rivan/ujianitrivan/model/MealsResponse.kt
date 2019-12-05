package com.rivan.ujianitrivan.model

import com.google.gson.annotations.SerializedName

data class MealsResponse(

	@field:SerializedName("meals")
	var meals: List<MealsItem>
)