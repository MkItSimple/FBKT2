package com.example.fbkt2.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.fbkt2.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_authors.*

/**
 * A simple [Fragment] subclass.
 */
class AuthorsFragment : Fragment() {

    lateinit var viewModel: AuthorsViewModel
    private val adapter = AuthorsAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authors, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProviders.of(this)[AuthorsViewModel::class.java]

        recycler_view_authors.adapter = adapter

//        viewModel.fetchAuthors()
//
//        viewModel.authors.observe(viewLifecycleOwner, Observer {
//            adapter.setAuthors(it)
//        })

        button_add.setOnClickListener {
            AddAuthorDialogFragment()
                .show(childFragmentManager, "")
        }
    }
}
