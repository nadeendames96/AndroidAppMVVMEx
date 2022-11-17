package com.techo.mvvmdesignpatternex.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techo.mvvmdesignpatternex.data.db.entities.User
import com.techo.mvvmdesignpatternex.data.network.MyApi
import com.techo.mvvmdesignpatternex.data.network.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {
    suspend fun userLogin(email:String,password:String): Response<AuthResponse>{
        return MyApi().UserLogin(email,password)
//    val loginResponse = MutableLiveData<String>()
//            MyApi().UserLogin(email,password)
//                .enqueue(object:Callback<ResponseBody>{
//                    override fun onResponse(
//                        call: Call<ResponseBody>,
//                        response: Response<ResponseBody>
//                    ) {
//                            if (response.isSuccessful){
//                                loginResponse.value = response.body().toString()
//                            }
//                        else {
//                                loginResponse.value = response.errorBody().toString()
//                            }
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                        loginResponse.value = t.message
//                    }
//
//                })
//        return  loginResponse
    }
}