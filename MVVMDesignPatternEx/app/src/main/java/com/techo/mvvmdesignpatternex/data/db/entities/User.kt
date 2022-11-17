package com.techo.mvvmdesignpatternex.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val current_User_ID = 0
@Entity
data class User
             (
                val id:Int?=null,
                var name:String?=null,
                var password:String?=null
){
    @PrimaryKey(autoGenerate = false)
    var uid = current_User_ID
             }