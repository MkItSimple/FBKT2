package com.example.fbkt2.data

import com.google.firebase.database.Exclude
import java.util.*

private val cities = listOf("Bangalore", "Mumbai", "Ranchi", "Kolkata", "Hyderabad", "Pune")

data class Author(
    @get:Exclude
    var id: String? = null,
    var name: String? = null,
    var city: String? = cities.random(),
    var votes: Int = (5..5000).random(),
    @get:Exclude
    var isDeleted: Boolean = false
){
    // To avoid duplicate
    override fun equals(other: Any?): Boolean {
        return if (other is Author) {
            other.id == id
        } else false
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

}