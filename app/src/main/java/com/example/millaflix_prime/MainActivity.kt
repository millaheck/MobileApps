package com.example.millaflix_prime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.millaflix_prime.models.Movie
import com.example.millaflix_prime.models.MovieResponse
import com.example.millaflix_prime.services.MovieApiInterface
import com.example.millaflix_prime.services.MovieApiService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private fun Gson.fromJson(java: Class<Array<Movie>>) {

}

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    //Creating an instance of the Adapter that will be used in the Recycler View
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creating the RecyclerView and setting the Layout Manager and the Adapter
        val rvMoviesList: RecyclerView = findViewById(R.id.rv_movies_list)
        rvMoviesList.layoutManager = LinearLayoutManager(this)
        rvMoviesList.setHasFixedSize(true)

        getMovieData { movies -> rvMoviesList.adapter = MovieAdapter(movies) }

        //URL with the movie data
        val url = "/3/movie/popular?api_key=3dd2e9620c3470b35804aecb40d5ffcf"

        //Making the request to get the movie data
        url.makeHTTPRequest()
    }

    private fun MovieAdapter(movies: List<Movie>): MovieAdapter {
        TODO("Not yet implemented")
    }

    //Method to make an HTTP request
    private fun String.makeHTTPRequest(){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(this)
            .build()
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed to make HTTP request")
            }

            //When the request is successful the following method is called
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    val gson = Gson()
                    gson.fromJson(Array<Movie>::class.java)
                    if (movieResponse != null) {
                        val movies = movieResponse.results
                        callback(movies)
                    }
                }
            }
        })
    }
}