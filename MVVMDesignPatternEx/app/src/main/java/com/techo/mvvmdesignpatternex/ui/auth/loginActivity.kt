package com.techo.mvvmdesignpatternex.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.techo.mvvmdesignpatternex.R
import com.techo.mvvmdesignpatternex.Util.hide
import com.techo.mvvmdesignpatternex.Util.show
import com.techo.mvvmdesignpatternex.Util.snackbar
import com.techo.mvvmdesignpatternex.Util.toast
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
        binding.PB.show()
    }
    override fun onSuccess(data: LiveData<String>) {
        binding.PB.hide()
       data.observe(this, Observer {
//           toast("is Logged in")
           binding.rootView.snackbar("User Logged In")
       })
    }
    override fun onFailure(msg: String) {
//        toast(msg)
        binding.rootView.snackbar(msg)
        binding.PB.hide()
    }
}