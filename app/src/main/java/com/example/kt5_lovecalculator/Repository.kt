package com.example.kt5_lovecalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kt5_lovecalculator.love.LoveAPI
import com.example.kt5_lovecalculator.love.LoveModel
import com.example.kt5_lovecalculator.room.AppDataBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor( private val api: LoveAPI , private val dao: AppDataBase) {

    fun getMutableLiveDataOfLoveData(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val liveLoveModel: MutableLiveData<LoveModel> = MutableLiveData()
/*
        dao.historyDao().getAll()
*/
        api.calculateLove(firstName, secondName).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveLoveModel.postValue(it)

                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message}")
            }
        })
        return liveLoveModel
    }

    fun getWeatherRoom() : LiveData<List<LoveModel>> {
        return dao.historyDao().getAll()
    }
}

