package com.techo.mvvmdesignpatternex.data.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techo.mvvmdesignpatternex.data.db.entities.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDeo():UserDeo
    companion object
    {
        @Volatile
        private var instance:AppDatabase?=null
        private val lock=Any()
        operator fun invoke(context: Context)= instance?: synchronized(lock){
            instance ?: buildDatabase(context).also {
                instance = instance
            }
        }

        private fun buildDatabase(context: Context) {
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
        }
    }
}