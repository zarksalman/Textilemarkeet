package com.textile.markeet.data.models.signin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseData {

    @SerializedName("data")
    @Expose
    var data: Data? = null
    @SerializedName("ID")
    @Expose
    var id: Int? = null
    @SerializedName("caps")
    @Expose
    var caps: Caps? = null
    @SerializedName("cap_key")
    @Expose
    var capKey: String? = null
    @SerializedName("roles")
    @Expose
    var roles: List<String>? = null
    @SerializedName("allcaps")
    @Expose
    var allcaps: Allcaps? = null
    @SerializedName("filter")
    @Expose
    var filter: Any? = null

}