package com.techo.mvvmdesignpatternex.Util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.toast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}
fun ProgressBar.show(){
    visibility = View.VISIBLE
}
fun ProgressBar.hide(){
    visibility = View.GONE
}
fun View.snackbar(msg:String){
    Snackbar.make(this,msg,Snackbar.LENGTH_LONG).also {snackbar->
        snackbar.setAction("OK"){
            snackbar.dismiss()
        }
    }.show()
}