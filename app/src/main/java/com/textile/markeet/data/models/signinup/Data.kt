package com.textile.markeet.data.models.signinup

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("data")
    @Expose
    private var data: Data_? = null
    @SerializedName("ID")
    @Expose
    private var iD: Int? = null
    @SerializedName("caps")
    @Expose
    private var caps: Caps? = null
    @SerializedName("cap_key")
    @Expose
    private var capKey: String? = null
    @SerializedName("roles")
    @Expose
    private var roles: List<String>? = null
    @SerializedName("allcaps")
    @Expose
    private var allcaps: Allcaps? = null
    @SerializedName("filter")
    @Expose
    private var filter: Any? = null

    fun getData(): Data_? {
        return data
    }

    fun setData(data: Data_) {
        this.data = data
    }

    fun getID(): Int? {
        return iD
    }

    fun setID(iD: Int?) {
        this.iD = iD
    }

    fun getCaps(): Caps? {
        return caps
    }

    fun setCaps(caps: Caps) {
        this.caps = caps
    }

    fun getCapKey(): String? {
        return capKey
    }

    fun setCapKey(capKey: String) {
        this.capKey = capKey
    }

    fun getRoles(): List<String>? {
        return roles
    }

    fun setRoles(roles: List<String>) {
        this.roles = roles
    }

    fun getAllcaps(): Allcaps? {
        return allcaps
    }

    fun setAllcaps(allcaps: Allcaps) {
        this.allcaps = allcaps
    }

    fun getFilter(): Any? {
        return filter
    }

    fun setFilter(filter: Any) {
        this.filter = filter
    }

}