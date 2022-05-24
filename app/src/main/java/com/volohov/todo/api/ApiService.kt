package com.volohov.todo.api

import com.volohov.todo.api.ApiConstants.Companion.API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val interceptor: HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }

val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(BasicAuthInterceptor("test-user", "qwerty123456"))
    .addInterceptor(interceptor)
    .build()

val api: ApiRequests = Retrofit.Builder()
    .baseUrl(API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(client)
    .build()
    .create(ApiRequests::class.java)
