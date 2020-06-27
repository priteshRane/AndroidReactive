package com.ransoft.androidreactive.coadingwithmitch.data.network

import com.ransoft.androidreactive.coadingwithmitch.data.modal.Comment
import com.ransoft.androidreactive.coadingwithmitch.data.modal.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    @GET("posts")
    fun getPosts() : Call<List<Post>>

    @GET("posts/{id}/comments")
    fun getComments() : Call<Comment>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
                .create(MyApi::class.java)
        }
    }
}