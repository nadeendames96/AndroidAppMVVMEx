package com.techo.mvvmdesignpatternex.ui.auth

import androidx.lifecycle.LiveData
import com.techo.mvvmdesignpatternex.data.db.entities.User

interface AuthListner {
    fun onStarted()
    fun onSuccess(data: LiveData<String>)
    fun onFailure(msg:String)
}