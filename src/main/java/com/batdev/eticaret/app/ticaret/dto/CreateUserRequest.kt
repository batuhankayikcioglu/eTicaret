package com.batdev.eticaret.app.ticaret.dto

data class CreateUserRequest(
        val mail: String,
        val firstName: String,
        val lastName: String,
        val middleName: String
) {
}