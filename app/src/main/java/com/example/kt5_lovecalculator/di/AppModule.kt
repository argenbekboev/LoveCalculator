package com.example.kt5_lovecalculator.di

import android.content.Context
import androidx.room.Room
import com.example.kt5_lovecalculator.Prefs
import com.example.kt5_lovecalculator.love.LoveAPI
import com.example.kt5_lovecalculator.room.AppDataBase
import com.example.kt5_lovecalculator.room.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi(): LoveAPI {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {

        return Room.databaseBuilder(context, AppDataBase::class.java, "database")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideHistoryDao(appDataBase: AppDataBase): HistoryDao {
        return appDataBase.historyDao()
    }
    @Singleton
    @Provides
    fun providePrefs(@ApplicationContext context: Context): Prefs {
        return Prefs(context)
    }

}




















