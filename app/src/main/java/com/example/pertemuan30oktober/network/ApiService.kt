package com.example.myapiapplication.network

import com.example.tugasapi.model.Surat
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("99c279bb173a6e28359c/data")
    fun getSurat(): Call<List<Surat>>
}

