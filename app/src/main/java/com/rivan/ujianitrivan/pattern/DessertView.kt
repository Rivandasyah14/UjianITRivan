package com.rivan.ujianitrivan.pattern

import com.rivan.ujianitrivan.base.BaseView
import com.rivan.ujianitrivan.model.MealsItem

interface DessertView : BaseView{
    fun error(message: String?)
    fun showDataDessert(item: List<MealsItem>)
}