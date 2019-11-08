package com.bignerdranch.android.restfu.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class DirectoryResponseEntity: Parcelable  {

@SerializedName("individuals")
var individuals: List<Record>? = null

}