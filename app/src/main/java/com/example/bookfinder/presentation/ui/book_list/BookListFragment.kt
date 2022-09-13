package com.example.bookfinder.presentation.ui.book_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookfinder.databinding.FragmentBookListBinding
import com.example.bookfinder.data.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookListFragment : Fragment(), SearchView.OnQueryTextListener {


    private val viewModel: BookListViewModel by viewModels()
    private lateinit var binding: FragmentBookListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (this::binding.isInitialized) {
            binding
        } else {
            binding = FragmentBookListBinding.inflate(inflater, container, false)
            binding.searchView.setOnQueryTextListener(this)
// do what ever you need to do in first creation
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.books.observe(viewLifecycleOwner, Observer { books ->
            binding.bookRecyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                if(books != null) it.adapter = BookListAdapter(books)
            }
        })
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null)
            viewModel.getBooks(query)
        binding.root.transitionToEnd()
        context?.let { Utils.hideSoftKeyBoard(it, binding.root) }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        return true
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

}