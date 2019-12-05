package com.rivan.ujianitrivan.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivan.ujianitrivan.BuildConfig
import com.rivan.ujianitrivan.R
import com.rivan.ujianitrivan.adapter.SeafoodAdapter
import com.rivan.ujianitrivan.model.MealsItem
import com.rivan.ujianitrivan.pattern.SeafoodPresenter
import com.rivan.ujianitrivan.pattern.SeafoodView
import kotlinx.android.synthetic.main.fragment_seafood.*
import org.jetbrains.anko.toast

/**
 * A simple [Fragment] subclass.
 */
class SeafoodFragment : Fragment(), SeafoodView {

    private lateinit var presenter: SeafoodPresenter
    private var mealsList: MutableList<MealsItem?>? = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seafood, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SeafoodPresenter()
        presenter.getDataSeafood()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun showDataMeals(item: List<MealsItem>) {
        mealsList?.clear()
        mealsList?.addAll(item)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_seafood.layoutManager = layoutManager
        rv_seafood.adapter = SeafoodAdapter(mealsList, context)
    }

    override fun error(message: String?) {
        context?.toast(message!!)
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
