package com.example.kt5_lovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kt5_lovecalculator.love.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}