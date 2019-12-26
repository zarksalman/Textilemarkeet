package com.textile.markeet.views.activities

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.textile.markeet.R
import com.textile.markeet.adapters.ParentCategoryAdapter
import com.textile.markeet.data.models.categories.CategoriesDataContainer
import com.textile.markeet.data.models.categories.ParentCategory
import com.textile.markeet.data.retrofit.RetrofitClient
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.helpers.AppPreference
import com.textile.markeet.viewmodels.CategoryViewModel
import kotlinx.android.synthetic.main.activity_parent_categories_list.*
import kotlinx.android.synthetic.main.m_tool_bar_with_searchbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParentCategoriesListActivity : BaseActivity() {

    private val TAG = "ParentCategoryActivity"
    private var categoryViewModel: CategoryViewModel? = null
    private var token: String? = null
    private var parentCategoryList: List<ParentCategory>? = null
    private var adapter: ParentCategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_categories_list)

        token = getString(AppConstants.TOKEN)
        token = token?.let {
            AppConstants.BEARER + it
        }
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        initUi()
        initListeners()
        initAdapter()
        getCategories()

    }

    private fun initUi() {

        sv_ads.queryHint = "Search Everything"
        sv_ads.isIconified = false
        sv_ads.clearFocus()

        showProgressBar()
    }

    private fun initListeners() {

        iv_sv_clickable.setOnClickListener {
        }

        btn_back.setOnClickListener { finish() }
    }

    private fun initAdapter() {

        adapter = ParentCategoryAdapter(this)
        rv_parent_category.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_parent_category.adapter = adapter
    }

    private fun getCategories() {

        categoryViewModel!!.getAllParentCategories(token)
            .observe(this, Observer { categoryDataContainer ->
                if (categoryDataContainer != null) {

                    parentCategoryList = categoryDataContainer.parentCategories

                    parentCategoryList?.let {
                        adapter?.setData(it)
                    }
                    Log.d(TAG, categoryDataContainer.message)
                }
                hideProgressBar()
            })
    }

}
