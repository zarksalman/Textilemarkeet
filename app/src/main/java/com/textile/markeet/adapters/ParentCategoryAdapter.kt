package com.textile.markeet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.textile.markeet.R
import com.textile.markeet.data.models.categories.ParentCategory
import kotlinx.android.synthetic.main.item_parent_category_layout.view.*

class ParentCategoryAdapter(val context: Context) :
    RecyclerView.Adapter<ParentCategoryAdapter.ParentCategoryViewHolder>() {

    private var parentCategoryList: List<ParentCategory> = listOf()
    val mContext: Context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentCategoryViewHolder {
        return ParentCategoryViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_parent_category_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParentCategoryViewHolder, position: Int) {
        holder.setCategoryName(parentCategoryList!![position].name)
    }

    override fun getItemCount(): Int {

        return parentCategoryList.size
    }

    fun setData(parentCategoryList: List<ParentCategory>) {

        this.parentCategoryList = parentCategoryList
        notifyDataSetChanged()
    }

    class ParentCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mView = view

        fun setCategoryName(name: String?) {

            name?.let {
                mView.tv_parent_category_name.text = name
            }
        }

    }
}