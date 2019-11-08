package com.bignerdranch.android.restfu.models

import com.bignerdranch.android.restfu.models.Address
import com.google.gson.annotations.SerializedName

class Employee {

    @SerializedName("firstName")
    var firstName: String? = null
    @SerializedName("lastName")
    var lastName: String? = null
    @SerializedName("email")
    var email: String? = null
    @SerializedName("phone")
    var phone: String? = null
    @SerializedName("altPhone")
    var altPhone: String? = null
    @SerializedName("userId")
    var userID: String? = null
    @SerializedName("address")
    var address: Address? = null
    @SerializedName("admin")
    var admin: Boolean? = null

}