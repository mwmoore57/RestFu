package com.bignerdranch.android.restfu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Record: Parcelable{

    @SerializedName("id")
    var id: Int? = null
    @SerializedName("firstName")
    var firstName: String? = null
    @SerializedName("lastName")
    var lastName: String? = null
    @SerializedName("birthdate")
    var birthdate: String? = null
    @SerializedName("profilePicture")
    var profilePicture: String? = null
    @SerializedName("forceSensitive")
    var forceSensitive: Boolean? = null
    @SerializedName("affiliation")
    var affiliation: String? = null

}
