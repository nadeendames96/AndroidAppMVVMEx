package com.techo.mvvmdesignpatternex.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.techo.mvvmdesignpatternex.R
import com.techo.mvvmdesignpatternex.Util.toast
import com.techo.mvvmdesignpatternex.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity(),AuthListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this)[AuthViewModel::class.java]
        binding.viewmodel = viewModel
        viewModel.authListner = this
    }

    override fun onStarted() {
   toast("Login Started")
        Log.wtf("ApppStart","App OnStarted")
    }
    override fun onSuccess() {
        toast("Login Success")
    }

    override fun onFailure(msg: String) {
        toast(msg)
    }
}