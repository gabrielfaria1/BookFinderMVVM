package com.example.bookfinder.network

import com.example.bookfinder.network.response.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(" ")
    suspend fun getBooks(
        @Query("q") inTitle: String,
        @Query("key") apiKey: String,
    ): Response<DataResponse>

}