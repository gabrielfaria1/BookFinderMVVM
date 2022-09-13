package com.example.bookfinder.data.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object Utils {

    fun hideSoftKeyBoard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}