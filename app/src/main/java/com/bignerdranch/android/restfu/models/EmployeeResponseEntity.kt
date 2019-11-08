package com.bignerdranch.android.restfu.models

import com.bignerdranch.android.restfu.models.Employee
import com.google.gson.annotations.SerializedName

class EmployeeResponseEntity {

    @SerializedName("listOfEmployees")
    var listOfEmployeess: List<Employee>? = null
    @SerializedName("allowNewUsers")
    var allowNewUsers: Boolean? = null
    @SerializedName("employeeJoinInstructions")
    var employeeJoinInstructions: String? = null
    @SerializedName("employeeJoinCode")
    var employeeJoinCode: Int? = null

}
