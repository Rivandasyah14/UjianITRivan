package com.rivan.ujianitrivan.pattern

import com.rivan.ujianitrivan.base.BaseView
import com.rivan.ujianitrivan.model.MealsItem

interface DetailView: BaseView {
    fun loadDataDetailMeals(item: List<MealsItem>)
    fun error(message: String?)
}