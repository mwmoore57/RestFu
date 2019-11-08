package com.bignerdranch.android.restfu.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitController {

    private var retrofit: Retrofit? = null
    val URL_PREFIX = "https://ldscdn.org/"
    val URL_PREFIX2 = "http://timeitrxbackend-env.d75gppg3fs.us-east-2.elasticbeanstalk.com/"


    fun getRetrofitInstance(baseUrl: String): Retrofit? {


            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpBuilder = OkHttpClient.Builder()
            okHttpBuilder.addInterceptor(loggingInterceptor)
            okHttpBuilder.addInterceptor { chain ->

                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "auth")
                    .addHeader("x-api-key","2431243API_KEYSDFAsdfjs32134")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Content-Type", "text/plain")
                    .addHeader("Content-Type", "charset=UTF-8")
                    .build()
                chain.proceed(request)
            }

            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build()

        return retrofit
    }

}