package com.example.fbkt2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fbkt2.data.Author
import com.example.fbkt2.data.NODE_AUTHORS
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AuthorsViewModel : ViewModel() {

    private val dbAuthors = FirebaseDatabase.getInstance().getReference("authors")

//    private val _authors = MutableLiveData<List<Author>>()
//    val authors: LiveData<List<Author>>
//        get() = _authors

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result


    fun addAuthor(author: Author) {
        author.id = dbAuthors.push().key
        dbAuthors.child(author.id!!).setValue(author)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }

//    fun fetchAuthors() {
//        dbAuthors.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {}
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()) {
//                    val authors = mutableListOf<Author>()
//                    for (authorSnapshot in snapshot.children) {
//                        val author = authorSnapshot.getValue(Author::class.java)
//                        author?.id = authorSnapshot.key
//                        author?.let { authors.add(it) }
//                    }
//                    _authors.value = authors
//                }
//            }
//        })
//    }
}