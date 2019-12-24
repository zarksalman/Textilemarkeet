package com.textile.markeet.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.textile.markeet.data.models.signinup.SignInUpDataContainer
import com.textile.markeet.data.repository.Repository
import com.textile.markeet.data.repository.Repository.Companion.instance

class SignInUpViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = instance

    fun signinForm(parameters: Map<String, String>): LiveData<SignInUpDataContainer> {
        return repository.signinForm(parameters)
    }

    fun signupForm(parameters: Map<String, String>): LiveData<SignInUpDataContainer> {
        return repository.signupForm(parameters)
    }

}