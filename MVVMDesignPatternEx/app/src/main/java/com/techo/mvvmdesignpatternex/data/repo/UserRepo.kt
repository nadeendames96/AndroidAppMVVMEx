package com.techo.mvvmdesignpatternex.data.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techo.mvvmdesignpatternex.data.db.entities.User
import com.techo.mvvmdesignpatternex.data.network.MyApi
import com.techo.mvvmdesignpatternex.data.network.SafeApiRequest
import com.techo.mvvmdesignpatternex.data.network.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo(private val context: Context) {
     fun userLogin(email:String,password:String):LiveData<String>{
//        return apiRequest {
//            MyApi().UserLogin(email,password)
//        }
    val loginResponse = MutableLiveData<String>()
            MyApi().UserLogin(email,password)
                .enqueue(object:Callback<AuthResponse>{
                    override fun onResponse(
                        call: Call<AuthResponse>,
                        response: Response<AuthResponse>
                    ) {
                            if (response.isSuccessful){
                                loginResponse.value = response.body().toString()
                            }
                        else {
                                loginResponse.value = response.errorBody().toString()
                            }
                    }

                    override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                        loginResponse.value = t.message
                    }

                })
        return  loginResponse
    }
    fun getUser():Boolean{
        Toast.makeText(context,"Get User Done", Toast.LENGTH_SHORT).show()
    return true
    }
}