package com.example.ptbfix.data.api

import com.example.ptbfix.data.api.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // Example endpoint - replace with your actual API endpoints
    @GET("endpoint")
    suspend fun getData(): Response<ApiResponse<Any>>

    // Add more endpoints as needed
    // @POST("login")
    // suspend fun login(@Body loginRequest: LoginRequest): Response<ApiResponse<LoginResponse>>
}
