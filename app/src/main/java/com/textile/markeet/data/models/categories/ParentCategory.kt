package com.textile.markeet.data.models.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ParentCategory {
    @SerializedName("term_id")
    @Expose
    var termId: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("subcategory")
    @Expose
    var subcategory: List<Subcategory>? = null

}