package com.thor.wisatamadiun.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    companion object {
        fun configNetwork(): Retrofit {
            return Retrofit.Builder()
                //http://192.168.1.21/WisataMadiun/
                //https://wisatamadiunraya.000webhostapp.com/WisataMadiun/
                .baseUrl("https://wisatamadiunraya.000webhostapp.com/WisataMadiun/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun service(): ApiService {
            return configNetwork().create((ApiService::class.java))
        }
    }

}