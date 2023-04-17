package com.example.millaflix_prime.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

@VersionedParcelize
data class MovieResponse(
    @SerializedName(value = "results")
    val movies: ArrayList<Movie>?

): Parcelable {
    val results: List<Movie>
        get() {
            TODO()
        }

    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Movie))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(movies)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResponse> {
        override fun createFromParcel(parcel: Parcel): MovieResponse {
            return MovieResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieResponse?> {
            return arrayOfNulls(size)
        }
    }
}