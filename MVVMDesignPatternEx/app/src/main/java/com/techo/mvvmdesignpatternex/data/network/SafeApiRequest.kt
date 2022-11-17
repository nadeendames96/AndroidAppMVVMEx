package com.techo.mvvmdesignpatternex.data.network

import com.techo.mvvmdesignpatternex.Util.ApiException
import org.json.JSONException
import retrofit2.Response

abstract class SafeApiRequest {
     suspend fun <T:Any> apiRequest(call:suspend ()->Response<T>):T{
        val response = call.invoke()
        if (response.isSuccessful){
            return response.body()!!
        }
        else{
            val error = response.errorBody()?.string()
            val msg = StringBuilder()
            msg.append("Error Code ${response.code()}")
            throw ApiException(msg.toString())
        }

    }
}