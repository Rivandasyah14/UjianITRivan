package com.rivan.ujianitrivan.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rivan.ujianitrivan.BuildConfig
import com.rivan.ujianitrivan.R
import com.rivan.ujianitrivan.adapter.DessertAdapter
import com.rivan.ujianitrivan.model.MealsItem
import com.rivan.ujianitrivan.pattern.DessertPresenter
import com.rivan.ujianitrivan.pattern.DessertView
import kotlinx.android.synthetic.main.fragment_dessert.*
import org.jetbrains.anko.toast

/**
 * A simple [Fragment] subclass.
 */
class DessertFragment : Fragment(), DessertView {

    private lateinit var presenter: DessertPresenter
    private var mealList: MutableList<MealsItem?>? = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dessert, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = DessertPresenter()
        presenter.getDataDessert()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun error(message: String?) {
        context?.toast(message!!)
    }

    override fun showDataDessert(item: List<MealsItem>) {
        mealList?.clear()
        mealList?.addAll(item)
        val layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false)
        rv_dessert.layoutManager = layoutManager
        rv_dessert.adapter = DessertAdapter(mealList, context)
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachView()
    }

}
