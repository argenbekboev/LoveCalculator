package com.example.kt5_lovecalculator

import android.app.Application
import androidx.room.Room
import com.example.kt5_lovecalculator.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        lateinit var dataBase: AppDataBase
        fun getInstance(): AppDataBase {
            return dp

        }

        lateinit var dp: AppDataBase

    }

    override fun onCreate() {
        super.onCreate()
        dp = Room.databaseBuilder(
            this, AppDataBase::class.java, "love-base"
        ).allowMainThreadQueries().build()
    }

    fun getDatabase(): AppDataBase {
        return dataBase


    }
}