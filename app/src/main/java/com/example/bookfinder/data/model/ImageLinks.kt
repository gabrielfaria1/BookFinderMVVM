package com.example.bookfinder.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageLinks(

    @SerializedName("smallThumbnail")
    var smallThumbnail: String? = "http://i.imgur.com/YjoNXCX.png",

    @SerializedName("thumbnail")
    var thumbnail: String? = "http://i.imgur.com/YjoNXCX.png"

) : Parcelable