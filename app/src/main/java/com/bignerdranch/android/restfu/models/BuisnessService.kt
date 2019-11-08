package com.bignerdranch.android.restfu.models

import com.google.gson.annotations.SerializedName

class BusinessService {

    @SerializedName("serviceId")
    var serviceId: Int? = null
    @SerializedName("serviceName")
    var serviceName: String? = null
    @SerializedName("durationInMin")
    var durationInMin: Int? = null
    @SerializedName("cost")
    var cost: Float? = null
    @SerializedName("businessId")
    var businessId: Int? = null
}