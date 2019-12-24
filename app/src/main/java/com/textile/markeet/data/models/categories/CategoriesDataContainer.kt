package com.textile.markeet.data.models.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoriesDataContainer {
    @SerializedName("data")
    @Expose
    var parentCategories: List<ParentCategory>? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

}