package nt.vn.mentorconnect.models

data class User(
    val id: String,
    val name:String,
    val email: String,
    val role: String,
    val isActive: Boolean
)
