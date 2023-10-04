package com.example.jokerapp.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.jokerapp.R
import com.example.jokerapp.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

data class CategoryItem(private val category: Category):Item<CategoryItem.CategoryViewHolder>() {
    class CategoryViewHolder(view:View):GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): CategoryViewHolder {
        return CategoryViewHolder(itemView)
    }

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text=category.nome
        viewHolder.itemView.findViewById<LinearLayout>(R.id.cotainer_category).setBackgroundColor(category.bgColor.toInt())
    }

    override fun getLayout(): Int {
        return R.layout.item_category
    }


}
