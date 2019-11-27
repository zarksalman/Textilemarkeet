package com.textile.markeet.data.models.signin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SigninDataContainer {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("Message")
    @Expose
    var message: String? = null
    @SerializedName("responseData")
    @Expose
    var responseData: ResponseData? = null

}