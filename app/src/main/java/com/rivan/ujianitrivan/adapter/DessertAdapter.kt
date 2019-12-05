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
import kotlinx.android.synthetic.main.item_dessert.view.*
import org.jetbrains.anko.startActivity

class DessertAdapter(
    private val dataMeal: List<MealsItem?>?,
    private val context: Context?
) : RecyclerView.Adapter<DessertAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                context
            ).inflate(R.layout.item_dessert, parent, false)
        )
    }

    override fun getItemCount(): Int = dataMeal?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataMeal?.get(position)!!)
    }

    class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bind(dataMeal: MealsItem) {

            Picasso.get().load(dataMeal.strMealThumb)
                .resize(150, 180).centerCrop().into(itemView.iv_item_dessert)

            containerView?.setOnClickListener {
                it.context.startActivity<DetailActivity>(
                    DetailActivity.ID to dataMeal.idMeal.toString(),
                    DetailActivity.TITLE to dataMeal.strMeal!!,
                    DetailActivity.IMAGES to dataMeal.strMealThumb!!
                )
            }
        }

    }
}