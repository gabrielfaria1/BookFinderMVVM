package com.example.bookfinder.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(

    @SerializedName("kind")
    var kind: String? = null,

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("etag")
    var etag: String? = null,

    @SerializedName("selfLink")
    var selfLink: String? = null,

    @SerializedName("volumeInfo")
    var bookInfo: BookInfo? = BookInfo()

) : Parcelable