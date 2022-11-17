package com.techo.mvvmdesignpatternex.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.techo.mvvmdesignpatternex.R
import com.techo.mvvmdesignpatternex.Util.hide
import com.techo.mvvmdesignpatternex.Util.show
import com.techo.mvvmdesignpatternex.Util.toast
import com.techo.mvvmdesignpatternex.data.db.entities.User
import com.techo.mvvmdesignpatternex.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity(),AuthListner {
    lateinit  var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this)[AuthViewModel::class.java]
        binding.viewmodel = viewModel
        viewModel.authListner = this
    }
    override fun onStarted() {
   toast("Login Started")
        Log.wtf("ApppStart","App OnStarted")
        binding.PB.show()
    }
    override fun onSuccess(user: User) {
        binding.PB.hide()
        toast("Login Success")
        toast("${user!!.name!!} is Logged in")
    }
    override fun onFailure(msg: String) {
        toast(msg)
        binding.PB.hide()
    }
}