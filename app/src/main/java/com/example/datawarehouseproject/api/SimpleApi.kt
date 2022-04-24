package com.example.retrofitdemo.api


import com.example.datawarehouseproject.model.Post2
import com.example.retrofittest.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @POST("predict/")
    suspend fun pushPost(
        @Header("Content-Type")  content_type: String ,
        @Body post: Post
    ): Response<Post2>


}