package com.example.bookfinder.network.response

import android.os.Parcelable
import com.example.bookfinder.data.model.Book

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse(


    @SerializedName("kind")
    var kind: String,

    @SerializedName("totalItems")
    var totalItems: Int,

    @SerializedName("items")
    var books: List<Book>

) : Parcelable