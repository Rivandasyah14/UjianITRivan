package com.rivan.ujianitrivan.pattern

import com.rivan.ujianitrivan.base.BaseView
import com.rivan.ujianitrivan.model.MealsItem

interface SeafoodView : BaseView{
    fun showDataMeals(item: List<MealsItem>)
    fun error(message: String?)
}