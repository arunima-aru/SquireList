package com.example.aethanalyticandroidmachinetest.api

import com.example.aethanalyticandroidmachinetest.dataClass.Model
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{
    @GET("orgs/square/repos")
    fun listSquareProduct(): Call<Model>
}