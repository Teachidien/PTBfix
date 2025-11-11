package com.example.ptbfix.data.repository

import com.example.ptbfix.data.api.RetrofitClient
import com.example.ptbfix.data.api.model.ApiResponse
import retrofit2.Response

class ApiRepository1 {
    private val apiService = RetrofitClient.apiService

    // Example function - replace with your actual API calls
    suspend fun fetchData(): Response<ApiResponse<Any>> {
        return apiService.getData()
    }

    // Add more repository functions for other API endpoints

    companion object {
        @Volatile
        private var instance: ApiRepository1? = null

        fun getInstance(): ApiRepository1 {
            return instance ?: synchronized(this) {
                instance ?: ApiRepository1().also { instance = it }
            }
        }
    }
}