package com.rivan.ujianitrivan.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rivan.ujianitrivan.R
import com.rivan.ujianitrivan.model.MealsItem
import com.rivan.ujianitrivan.pattern.DetailPresenter
import com.rivan.ujianitrivan.pattern.DetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity(), DetailView {

    companion object {
        const val ID: String = "ID"
        const val TITLE: String = "TITLE"
        const val IMAGES: String = "IMAGES"
    }

    lateinit var presenter: DetailPresenter
    lateinit var id: String
    lateinit var title: String
    lateinit var images: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter = DetailPresenter(this)

        id = intent.getStringExtra(ID)
        title = intent.getStringExtra(TITLE)
        images = intent.getStringExtra(IMAGES)

        tv_title_detail_seafood.text = title

        Picasso.get().load(images)
            .resize(180,180)
            .centerCrop()
            .into(iv_detail_seafood)
    }

    override fun loadDataDetailMeals(item: List<MealsItem>) {

    }

    override fun error(message: String?) {
        toast(message!!)
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
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
