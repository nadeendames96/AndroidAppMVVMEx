package com.techo.mvvmdesignpatternex.data.network

import com.techo.mvvmdesignpatternex.data.db.entities.User
import com.techo.mvvmdesignpatternex.data.network.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
//    @GET("UsersLogin")
//    fun UserLogin(@Field("email") email:String,@Field("password") paswword:String):Call<ResponseBody>
@POST("UsersLogin")
 suspend fun UserLogin(@Field("email") email:String,@Field("password")password:String):Response<AuthResponse>
    companion object{
    operator  fun invoke():MyApi{
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000"+"/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
}
}