package com.techo.mvvmdesignpatternex.ui.auth

import android.content.Intent
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
import com.techo.mvvmdesignpatternex.data.repo.UserRepo
import com.techo.mvvmdesignpatternex.databinding.ActivityLoginBinding
import com.techo.mvvmdesignpatternex.ui.home.HomeActivity

class loginActivity : AppCompatActivity(),AuthListner {
    lateinit  var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val repo =UserRepo (this)
        val factory = AuthViewModelFactory(repo)
        val viewModel = ViewModelProviders.of(this,factory)[AuthViewModel::class.java]
        binding.viewmodel = viewModel
        viewModel.authListner = this
        if(viewModel.getUserLoggedIn()){
            val intent = Intent(this,HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        else{
            toast("Please try again!")
        }
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