package com.example.storyappdaggerhilt

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("/v1/register")
    fun register(@Body registerRequest: RegisterRequest): Call<Response>

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("/v1/stories")
    @Multipart
    fun addNewStory(
        @Header ("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody
    ): Call<Response>

    @GET("/v1/stories")
    fun getAllStory(@Header ("Authorization") token: String): Call<GetAllStoriesResponse>

    @GET("/v1/stories/{id}")
    fun getDetailStory(@Header ("Authorization") token: String, @Path("id") id: String): Call<DetailStoryResponse>
}