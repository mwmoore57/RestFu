package com.bignerdranch.android.restfu.networking

import com.bignerdranch.android.restfu.models.BusinessService
import com.bignerdranch.android.restfu.models.DirectoryResponseEntity
import com.bignerdranch.android.restfu.models.EmployeeResponseEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface NetworkService {

    @GET("mobile/interview/directory")
    fun getDirectory(): Call<DirectoryResponseEntity>

    @GET("api/business/ftt/v1/offeredservice")
    fun getServices(): Call<List<BusinessService>>

    @POST("api/business/ftt/v1/employees")
    fun postService(@Body body: List<String>): Call<EmployeeResponseEntity>

}