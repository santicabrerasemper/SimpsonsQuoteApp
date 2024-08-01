package com.example.thesimpsonsquoteapp.network

import com.example.thesimpsonsquoteapp.models.SimpsonCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("quotes?count=12")
    suspend fun getCharacters(): Response<List<SimpsonCharacter>>

    @GET("quotes")
    suspend fun getCharacter(
        @Query("character") character: String
    ): Response<List<SimpsonCharacter>>
}