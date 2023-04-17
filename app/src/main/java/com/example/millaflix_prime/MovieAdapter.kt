package com.example.millaflix_prime

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.millaflix_prime.models.Movie

private const val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

class MovieAdapter(private var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)
        private val movieReleaseDate: TextView = itemView.findViewById(R.id.movie_release_date)
        private val movieTitle: TextView = itemView.findViewById(R.id.movie_title)

        fun bindMovie(movie: Movie) {
            movieTitle.text = movie.title
            movieReleaseDate.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(moviePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindMovie(movie)
    }

    //Data set size return
    override fun getItemCount(): Int {
        return movies.size
    }

    //Updating a movie in the list
    @SuppressLint("NotifyDataSetChanged")
    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovie(updatedMovie: Movie) {
        val index = movies.indexOfFirst { it.id == updatedMovie.id }
        if (index != -1) {
            val updatedMovies = movies.toMutableList()
            updatedMovies[index] = updatedMovie
            movies = updatedMovies
            notifyDataSetChanged()
        }
    }
}
