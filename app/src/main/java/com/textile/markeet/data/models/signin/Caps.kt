package com.textile.markeet.data.models.signin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Caps {

    @SerializedName("subscriber")
    @Expose
    var subscriber: Boolean? = null

}
