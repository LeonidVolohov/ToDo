package com.volohov.todo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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

                    todoListsAdapter = ToDoListsRecyclerAdapter(response)
                    todo_recycler_view.layoutManager = LinearLayoutManager(this)
                    todo_recycler_view.adapter = todoListsAdapter
                    todo_recycler_view.addItemDecoration(
                        DividerItemDecoration(
                            this,
                            LinearLayoutManager.VERTICAL
                        )
                    )

                },
                { failure ->
                    Log.e("MainActivity", failure.message.toString())
                    Toast.makeText(this, failure.message.toString(), Toast.LENGTH_LONG).show()
                }
            )


        /*api.addToDoList(ApiDataModel.ToDoLists(true, 100.0, "testtt"))
            .enqueue(
                object: Callback<ApiDataModel.ToDoListsResponse> {
                    override fun onFailure(call: Call<ApiDataModel.ToDoLists>, throwable: Throwable) {
                        Log.e("MainActivity", throwable.message.toString())
                        Toast.makeText(applicationContext, throwable.message.toString(), Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse( call: Call<ApiDataModel.ToDoLists>, response: Response<ApiDataModel.ToDoLists>) {


                    }
                }
            )*/


    }
}