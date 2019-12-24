package com.textile.markeet.data.models.signinup

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SignInUpDataContainer {
    
    @SerializedName("session_token")
    @Expose
    private var sessionToken: String? = null
    @SerializedName("code")
    @Expose
    private var code: Int? = null
    @SerializedName("data")
    @Expose
    private var data: Data? = null
    @SerializedName("message")
    @Expose
    private var message: String? = null

    fun getSessionToken(): String? {
        return sessionToken
    }

    fun setSessionToken(sessionToken: String) {
        this.sessionToken = sessionToken
    }

    fun getCode(): Int? {
        return code
    }

    fun setCode(code: Int?) {
        this.code = code
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data) {
        this.data = data
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

}