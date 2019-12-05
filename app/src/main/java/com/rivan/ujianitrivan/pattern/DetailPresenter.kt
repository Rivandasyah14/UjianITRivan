package com.rivan.ujianitrivan.pattern

import android.content.Context
import com.rivan.ujianitrivan.base.BasePresenter

class DetailPresenter(var context: Context): BasePresenter<DetailView> {
    var detailView: DetailView? = null

    override fun onAttach(view: DetailView) {
        detailView = view
    }

    override fun onDetach() {
        detailView = null
    }
}