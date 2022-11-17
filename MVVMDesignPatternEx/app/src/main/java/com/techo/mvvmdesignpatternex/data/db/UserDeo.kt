package com.techo.mvvmdesignpatternex.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techo.mvvmdesignpatternex.data.db.entities.User
import com.techo.mvvmdesignpatternex.data.db.entities.current_User_ID

@Dao
interface UserDeo {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updert(user: User):Long

    @Query("select * from user where uid = $current_User_ID")
    fun getUser() : LiveData<User>
}