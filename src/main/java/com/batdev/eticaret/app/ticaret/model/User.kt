package com.batdev.eticaret.app.ticaret.model

import jakarta.persistence.Entity

@Entity
data class User(

        val id: Long? = null,
        val mail: String,
        val firstName: String,
        val lastName: String,
        val middleName: String

){

}