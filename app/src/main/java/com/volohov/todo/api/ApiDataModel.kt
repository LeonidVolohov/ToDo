package com.volohov.todo.api

import com.google.gson.annotations.SerializedName

object  ApiDataModel {
    data class ToDoLists(
        @SerializedName("completed") val isCompleted: Boolean,
        @SerializedName("completion_progress") val completionProgress: Double,
        @SerializedName("name") val name: String
    )

    data class ToDoListsResponse(
        val code: Int,
        val detail: String,
        val todoList: ToDoLists
    )
}