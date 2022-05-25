package com.volohov.todo.api

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiUtils {

    fun getToDoLists(): Observable<List<ApiDataModel.ToDoLists>>? {
        return api.getToDoLists()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}