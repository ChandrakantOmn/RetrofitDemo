package com.c.kotlinconcept.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Chandra Kant on 12/7/19.
 */
/**
 * Created by Chandra Kant on 12/7/19.
 */
class RetrofitClient {
    lateinit var routeApi: GFAPIInterface

    fun initOTPHost() {
        val httpClient = clientBuilder()
        routeApi = Retrofit.Builder()
            .baseUrl("http://api.barnco99.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(GFAPIInterface::class.java)
    }


    private fun clientBuilder(): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return httpClient
    }

}