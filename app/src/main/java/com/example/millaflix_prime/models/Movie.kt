package com.example.millaflix_prime.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName


@VersionedParcelize
data class Movie (
    @SerializedName(value = "id")
    val id : String ?,

    @SerializedName(value = "title")
    val title : String?,

    @SerializedName(value = "poster_path")
    val poster : String?,

    @SerializedName(value = "release_date")
    val release : String?

    ):Parcelable {

    constructor() : this(id = "", title = "", poster = "", release = "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeString(release)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie().apply {
                var id = parcel.readString()
                var title = parcel.readString()
                var poster = parcel.readString()
                var release = parcel.readString()
            }

        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
