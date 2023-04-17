package com.example.millaflix_prime.services

import com.example.millaflix_prime.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET (value = "/3/movie/popular?api_key=3dd2e9620c3470b35804aecb40d5ffcf")
    fun getMovieList(): Call<MovieResponse>

}