package com.volohov.todo.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiRequests {

    @GET("todo/lists/")
    fun getToDoLists(): Observable<List<ApiDataModel.ToDoLists>>


    @Headers("Content-Type: application/json")
    @POST("todo/lists/")
    fun addToDoList(@Body todoListData: ApiDataModel.ToDoLists): Call<ApiDataModel.ToDoListsResponse>
}