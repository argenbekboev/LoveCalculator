package com.example.kt5_lovecalculator.love
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveAPI {
    @GET("getPercentage")
    fun calculateLove(
        @Query("fname") firstName:String,
        @Query("sname") secondName:String,
        @Header("X-RapidAPI-Key") key:String = "912caec55dmsh516b6c70ec91c74p1c66b6jsn75d31c51a884",
        @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com"
    ): retrofit2.Call<LoveModel>

}