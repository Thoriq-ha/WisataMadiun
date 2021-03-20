package com.thor.wisatamadiun.network

import com.thor.wisatamadiun.model.ResponseGetData
import com.thor.wisatamadiun.model.ResponseGetKategori
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getKategori.php")
    fun getKategori(): Call<ResponseGetKategori>

    @GET("getItem.php")
    fun getItemById(@Query("id_kategori") id_kategori: Int): Call<ResponseGetData>

    @GET("getItem.php")
    fun getItem(): Call<ResponseGetData>
}