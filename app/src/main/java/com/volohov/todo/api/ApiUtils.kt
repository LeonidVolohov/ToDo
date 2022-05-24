package com.volohov.todo.api

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable

class ApiUtils {

    fun getToDoLists(): Observable<List<ApiDataModel.ToDoLists>>? {
        return api.getToDoLists()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}