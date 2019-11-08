package com.bignerdranch.android.restfu.models

import com.google.gson.annotations.SerializedName

class Address {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("streetLine1")
    var streetLine1: String? = null
    @SerializedName("streetLine2")
    var streetLine2: String? = null
    @SerializedName("city")
    var city: String? = null
    @SerializedName("state")
    var state: String? = null
    @SerializedName("zip")
    var zip: String? = null
    @SerializedName("userId")
    var userId: String? = null
    @SerializedName("businessId")
    var businessId: String? = null

}