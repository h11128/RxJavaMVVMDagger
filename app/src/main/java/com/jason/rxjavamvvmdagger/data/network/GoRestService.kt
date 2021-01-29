package com.jason.rxjavamvvmdagger.data.network

import com.jason.rxjavamvvmdagger.data.model.GetAllUserResponse
import io.reactivex.Single
import retrofit2.http.GET


const val baseUrl = "https://gorest.co.in"
const val endpoint_getAllUser = "/public-api/users"
const val endpoint_getAllPost = "/public-api/posts"

interface GoRestService {
    @GET(endpoint_getAllUser)
    fun getAllUser(): Single<GetAllUserResponse>


}