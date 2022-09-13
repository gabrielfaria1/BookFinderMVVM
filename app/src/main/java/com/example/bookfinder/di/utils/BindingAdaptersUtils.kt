package com.example.bookfinder.di.utils

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ms.square.android.expandabletextview.ExpandableTextView

object BindingAdaptersUtils {

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookAuthor")
    fun setBookAuthorText(authorTextView : TextView , authorName : String) {
        if (authorName != "null"){
            val textHolder = "By $authorName"
            authorTextView.text = textHolder
        }
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookRate")
    fun setBookRatingBar(bookRatingBar : RatingBar, bookRate : Double) {
        bookRatingBar.rating = bookRate.toFloat()
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookThumbnail")
    fun setBookCover(bookThumbnail : ImageView, thumbnailLink : String) {
        Glide.with(bookThumbnail.context)
            .load(thumbnailLink.replace("http", "https"))
            .into(bookThumbnail)
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookPageCount")
    fun setBookPageCount(bookPageCount : TextView, pageCount : Int) {
        val textHolder = "$pageCount Pages"
        bookPageCount.text = textHolder
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookReviews")
    fun setBookReviews(bookReviewsCount : TextView, bookReviews : Int) {
        val textHolder = if (bookReviews.toString() != "null") "($bookReviews)" else "(0)"
        bookReviewsCount.text = textHolder
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookDescription")
    fun setBookDescription(bookDescription : ExpandableTextView, description : String?) {
        val textHolder = description ?: "No description available"
        bookDescription.text = textHolder
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookDate")
    fun setDate(dateTextView: TextView, date: String?) {
        val textHolder = if(date != null) "Published date: $date" else "Published date not available"
        dateTextView.text = textHolder
    }


    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:bookPublisher")
    fun setPublisher(publisherTextView: TextView, publisher: String?) {
        val textHolder = if(publisher != null) "Publisher: $publisher" else "Publisher details not available"
        publisherTextView.text = textHolder
    }

}