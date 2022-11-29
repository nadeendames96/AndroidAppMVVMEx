package com.techo.mvvmdesignpatternex.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.techo.mvvmdesignpatternex.data.repo.UserRepo

class AuthViewModel(private val repo: UserRepo) : ViewModel() {
    var email:String? = null
    var password : String? = null
    var authListner:AuthListner? = null

    // Observer User Login
    fun getUserLoggedIn() = repo.getUser()
    fun onBtnClickListner(view:View){
        this.authListner?.onStarted()
        if (this.email.isNullOrEmpty() || this.password.isNullOrEmpty()){
            //
            this.authListner?.onFailure("invaild username or password")
            return
        }
        val loginResponse = repo.userLogin(email!!,password!!)
        this.authListner?.onSuccess(loginResponse)
//        Couroutines.main {
////                if (loginResponse.isSuccessful){
////                    authListner?.onSuccess(loginResponse.body()!!.user!!)
////                }
////            else{
////                authListner?.onFailure("Error code ${loginResponse.code()}")
////                }
//            try{
//                val loginResponse = UserRepo().userLogin(email!!,password!!)
//                loginResponse.user?.let {
//                    authListner?.onSuccess(it)
//                    return@main
//                }
//            }
//            catch (e:ApiException){
//                authListner?.onFailure(e.message!!)
//            }
//        }
    }

}