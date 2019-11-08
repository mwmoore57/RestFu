package com.bignerdranch.android.restfu.networking

import com.bignerdranch.android.restfu.networking.RetrofitController.URL_PREFIX
import com.bignerdranch.android.restfu.networking.RetrofitController.URL_PREFIX2
import com.bignerdranch.android.restfu.models.BusinessService
import com.bignerdranch.android.restfu.models.DirectoryResponseEntity
import com.bignerdranch.android.restfu.models.EmployeeResponseEntity


object DirectoryFacade {

    fun getDirectory( callback: retrofit2.Callback<DirectoryResponseEntity>) {
        val directoryApiService= RetrofitController.getRetrofitInstance(
            URL_PREFIX
        )!!.create(NetworkService::class.java)
        directoryApiService.getDirectory().enqueue(callback)
    }

    fun getServices( callback: retrofit2.Callback<List<BusinessService>>) {
        val directoryApiService= RetrofitController.getRetrofitInstance(
            URL_PREFIX2
        )!!.create(NetworkService::class.java)
        directoryApiService.getServices().enqueue(callback)
    }

    fun postService(body: List<String>, callback: retrofit2.Callback<EmployeeResponseEntity>) {
        val directoryApiService = RetrofitController.getRetrofitInstance(
            URL_PREFIX2
        )!!.create(NetworkService::class.java)
        directoryApiService.postService(body).enqueue(callback)
    }
}