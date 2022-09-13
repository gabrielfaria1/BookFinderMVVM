package com.example.bookfinder.repository

import com.example.bookfinder.network.response.DataResponse

interface BooksRepository {

    suspend fun getBooks(tittle: String): DataResponse
}