package com.volohov.todo.api

import retrofit2.http.GET
import io.reactivex.Observable

interface ApiRequests {

    @GET("todo/lists/")
    fun getToDoLists(): Observable<List<ApiDataModel.ToDoLists>>

}