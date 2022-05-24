package com.volohov.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.volohov.todo.api.ApiUtils
import com.volohov.todo.todolistsrecycler.ToDoListsRecyclerAdapter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.recyclerview.*

class MainActivity : AppCompatActivity() {
    private var disposable: Disposable? = null
    private lateinit var todoListsAdapter: ToDoListsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)

        disposable = ApiUtils().getToDoLists()
            ?.subscribe(
                {response ->
                    Log.d("MainActivity", response.toString())

                    val items = response
                    val itemsList: MutableList<String> = ArrayList()
                    for(i in 0 until response.count()) {
                        itemsList.add(response[i].name)
                        Log.d("MainActivity", response[i].name)
                    }

                    todoListsAdapter = ToDoListsRecyclerAdapter(itemsList)
                    todo_recycler_view.adapter = todoListsAdapter

                    Log.d("MainActivity", itemsList.toString())

                },
                {failure ->
                    Log.e("MainActivity", failure.message.toString())
                    Toast.makeText(this, failure.message.toString(), Toast.LENGTH_LONG).show()
                }
            )
    }
}