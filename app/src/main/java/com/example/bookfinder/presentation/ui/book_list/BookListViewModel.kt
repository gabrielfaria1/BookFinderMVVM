package com.example.bookfinder.presentation.ui.book_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookfinder.network.utils.Coroutines
import com.example.bookfinder.data.model.Book
import com.example.bookfinder.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val repository: BooksRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>>
        get() = _books


    fun getBooks(tittle: String) {
        job = Coroutines.ioThenMain(
            { repository.getBooks(tittle) },
            { _books.value = it!!.books }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}