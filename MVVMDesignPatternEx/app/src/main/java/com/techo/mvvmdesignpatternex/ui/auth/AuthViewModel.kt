package com.techo.mvvmdesignpatternex.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var email:String? = null
    var password : String? = null
    var authListner:AuthListner? = null
    fun onBtnClickListner(view:View){
        this.authListner?.onStarted()
        if (this.email.isNullOrEmpty() || this.password.isNullOrEmpty()){
            //
            this.authListner?.onFailure("invaild username or password")
            return
        }
        this.authListner?.onSuccess()
    }
}