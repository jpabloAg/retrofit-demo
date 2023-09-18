package com.example.consumeapijetpackcompose

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("/posts")
    suspend fun getPosts(): Response<ArrayList<PostsResponse>>

    @GET("/posts/{id}")
    suspend fun getPost(
        @Path("id") id: String
    ): Response<PostsResponse>
}