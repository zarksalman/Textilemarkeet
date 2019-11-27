package com.textile.markeet.data.models.signin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Allcaps {

    @SerializedName("read")
    @Expose
    var read: Boolean? = null
    @SerializedName("level_0")
    @Expose
    var level0: Boolean? = null
    @SerializedName("subscriber")
    @Expose
    var subscriber: Boolean? = null

}