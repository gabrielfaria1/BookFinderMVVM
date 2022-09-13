package com.example.bookfinder.repository

import com.example.bookfinder.network.ApiService
import com.example.bookfinder.network.SafeApiRequest
import com.example.bookfinder.domain.utils.Constants.Companion.API_KEY

class BooksRepositoryImpl (private val apiService: ApiService) : BooksRepository, SafeApiRequest() {

    override suspend fun getBooks(tittle: String) = apiRequest { apiService.getBooks(tittle, API_KEY) }




}