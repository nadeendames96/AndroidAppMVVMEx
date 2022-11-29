package com.techo.mvvmdesignpatternex.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techo.mvvmdesignpatternex.data.repo.UserRepo

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(private val repo:UserRepo):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repo) as T
    }
}