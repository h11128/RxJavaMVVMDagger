package com.jason.rxjavamvvmdagger.data.model

data class GetAllUserResponse(
    val code: Int,
    val `data`: List<User>,
    val meta: Meta
)

data class User(
    val created_at: String,
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String,
    val updated_at: String
)

data class Meta(
    val pagination: Pagination
)

data class Pagination(
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)