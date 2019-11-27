package com.textile.markeet.data.models.signin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("ID")
    @Expose
    var id: String? = null
    @SerializedName("user_login")
    @Expose
    var userLogin: String? = null
    @SerializedName("user_pass")
    @Expose
    var userPass: String? = null
    @SerializedName("user_nicename")
    @Expose
    var userNicename: String? = null
    @SerializedName("user_email")
    @Expose
    var userEmail: String? = null
    @SerializedName("user_url")
    @Expose
    var userUrl: String? = null
    @SerializedName("user_registered")
    @Expose
    var userRegistered: String? = null
    @SerializedName("user_activation_key")
    @Expose
    var userActivationKey: String? = null
    @SerializedName("user_status")
    @Expose
    var userStatus: String? = null
    @SerializedName("display_name")
    @Expose
    var displayName: String? = null

}