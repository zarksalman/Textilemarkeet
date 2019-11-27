package com.textile.markeet.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.textile.markeet.data.models.signin.SigninDataContainer
import com.textile.markeet.data.retrofit.RetrofitClient
import com.textile.markeet.data.retrofit.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository private constructor() {
    private val serviceApi: ServiceApi = RetrofitClient.getInstance().createClient()
    internal lateinit var signinDataContainerMutableLiveData: MutableLiveData<SigninDataContainer>


    fun signinForm(parameters: MutableMap<String, String>): LiveData<SigninDataContainer> {

        signinDataContainerMutableLiveData = MutableLiveData()

        serviceApi.signinForm(parameters).enqueue(object : Callback<SigninDataContainer> {

            override fun onResponse(
                call: Call<SigninDataContainer>,
                response: Response<SigninDataContainer>
            ) {

                if (response.isSuccessful)
                    signinDataContainerMutableLiveData.postValue(response.body())
                else
                    signinDataContainerMutableLiveData.postValue(null)
            }

            override fun onFailure(call: Call<SigninDataContainer>, t: Throwable) {
                signinDataContainerMutableLiveData.postValue(null)
            }
        })

        return signinDataContainerMutableLiveData
    }

    companion object {

        private var repository: Repository? = null

        internal var token: String? = null

        val instance: Repository
            get() {
                if (repository == null) {
                    repository = Repository()
                }

                return repository!!
            }
    }
}