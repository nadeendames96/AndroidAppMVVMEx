package com.techo.mvvmdesignpatternex.ui.auth

interface AuthListner {
    fun onStarted()
    fun onSuccess()
    fun onFailure(msg:String)
}