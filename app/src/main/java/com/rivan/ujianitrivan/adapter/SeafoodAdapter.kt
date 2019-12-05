package com.rivan.ujianitrivan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rivan.ujianitrivan.R
import com.rivan.ujianitrivan.activity.DetailActivity
import com.rivan.ujianitrivan.model.MealsItem
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_seafood.view.*
import org.jetbrains.anko.startActivity

class SeafoodAdapter (
    private val dataMeals: List<MealsItem?>?,
    private val context: Context?
) :
    RecyclerView.Adapter<SeafoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                    context
                ).inflate(R.layout.item_seafood, parent, false)
        )
    }

    override fun getItemCount(): Int = dataMeals?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataMeals?.get(position)!!)
    }

    class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView!!), LayoutContainer {

        fun bind(dataMeals: MealsItem) {
            itemView.tv_title_item_seafood.text = dataMeals.strMeal

            Picasso.get().load(dataMeals.strMealThumb)
                .resize(150, 150).centerCrop().into(itemView.iv_item_seafood)

            containerView?.setOnClickListener {
                it.context.startActivity<DetailActivity>(
                    DetailActivity.ID to dataMeals.idMeal.toString(),
                    DetailActivity.TITLE to dataMeals.strMeal!!,
                    DetailActivity.IMAGES to dataMeals.strMealThumb!!
                )
            }
        }

    }
}