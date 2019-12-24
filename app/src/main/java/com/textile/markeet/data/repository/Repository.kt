package com.textile.markeet.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.textile.markeet.data.models.categories.CategoriesDataContainer
import com.textile.markeet.data.models.signinup.SignInUpDataContainer
import com.textile.markeet.data.retrofit.RetrofitClient
import com.textile.markeet.data.retrofit.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository private constructor() {
    private val serviceApi: ServiceApi = RetrofitClient.getInstance().createClient()
    internal lateinit var signInUpDataContainerMutableLiveData: MutableLiveData<SignInUpDataContainer>
    internal lateinit var categoriesDataContainer: MutableLiveData<CategoriesDataContainer>

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

    fun signinForm(parameters: Map<String, String>): LiveData<SignInUpDataContainer> {

        signInUpDataContainerMutableLiveData = MutableLiveData()

        serviceApi.signinForm(parameters).enqueue(object : Callback<SignInUpDataContainer> {
            override fun onResponse(
                call: Call<SignInUpDataContainer>,
                response: Response<SignInUpDataContainer>
            ) {

                if (response.isSuccessful)
                    signInUpDataContainerMutableLiveData.postValue(response.body())
                else
                    signInUpDataContainerMutableLiveData.postValue(null)
            }

            override fun onFailure(call: Call<SignInUpDataContainer>, t: Throwable) {
                signInUpDataContainerMutableLiveData.postValue(null)
            }
        })

        return signInUpDataContainerMutableLiveData
    }

    fun signupForm(parameters: Map<String, String>): LiveData<SignInUpDataContainer> {

        signInUpDataContainerMutableLiveData = MutableLiveData()

        serviceApi.signupForm(parameters).enqueue(object : Callback<SignInUpDataContainer> {
            override fun onResponse(
                call: Call<SignInUpDataContainer>,
                response: Response<SignInUpDataContainer>
            ) {

                if (response.isSuccessful)
                    signInUpDataContainerMutableLiveData.postValue(response.body())
                else
                    signInUpDataContainerMutableLiveData.postValue(null)
            }

            override fun onFailure(call: Call<SignInUpDataContainer>, t: Throwable) {
                signInUpDataContainerMutableLiveData.postValue(null)
            }
        })

        return signInUpDataContainerMutableLiveData
    }

    fun getAllParentCategories(parameters: String): LiveData<CategoriesDataContainer> {

        categoriesDataContainer = MutableLiveData()

        serviceApi.getCategories(parameters).enqueue(object : Callback<CategoriesDataContainer> {

            override fun onResponse(
                call: Call<CategoriesDataContainer>,
                response: Response<CategoriesDataContainer>
            ) {

                if (response.isSuccessful) {
                    categoriesDataContainer.postValue(response.body())
                } else {
                    categoriesDataContainer.postValue(null)
                }
            }

            override fun onFailure(call: Call<CategoriesDataContainer>, t: Throwable) {
                categoriesDataContainer.postValue(null)
            }
        })

        return categoriesDataContainer
    }

}