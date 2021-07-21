package com.example.restapp

import retrofit2.http.GET

interface ItemService {
    @GET("items")
    suspend fun getAllItems(): List<Item>
    }