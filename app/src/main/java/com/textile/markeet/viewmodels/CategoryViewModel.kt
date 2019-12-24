package com.textile.markeet.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.textile.markeet.data.models.categories.CategoriesDataContainer
import com.textile.markeet.data.repository.Repository
import com.textile.markeet.data.repository.Repository.Companion.instance

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = instance

    fun getAllParentCategories(sessionToken: String?): LiveData<CategoriesDataContainer> {
        return repository.getAllParentCategories(sessionToken!!)
    }

}