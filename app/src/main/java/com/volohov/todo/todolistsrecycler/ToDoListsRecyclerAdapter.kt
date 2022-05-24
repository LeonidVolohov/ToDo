package com.volohov.todo.todolistsrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volohov.todo.R
import com.volohov.todo.api.ApiDataModel
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class ToDoListsRecyclerAdapter(private val toDoList: MutableList<String>):
        RecyclerView.Adapter<ToDoListsRecyclerAdapter.ToDoListsViewHolder>() {
    //private var toDoList: MutableList<ApiDataModel.ToDoLists> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return ToDoListsViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ToDoListsViewHolder, position: Int) {
        val item = toDoList[position]
        holder.bindToDos(item)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    class ToDoListsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindToDos(todo: ApiDataModel.ToDoLists) {
            itemView.todo_item?.text = todo.name
        }
    }

}