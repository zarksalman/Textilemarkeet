package com.textile.markeet.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.textile.markeet.data.models.signin.SigninDataContainer;
import com.textile.markeet.data.repository.Repository;

import java.util.Map;

public class SigninViewModel extends AndroidViewModel {

    private static Repository repository;

    public SigninViewModel(@NonNull Application application) {
        super(application);

        repository = Repository.Companion.getInstance();

    }

    public LiveData<SigninDataContainer> signinForm(Map<String, String> parameters) {

        return repository.signinForm(parameters);
    }
}
