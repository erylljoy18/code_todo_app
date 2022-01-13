package com.example.todoapp.presenter

import android.content.Context
import android.widget.Toast
import com.example.todoapp.DBHelper
import com.example.todoapp.model.TodoModel

class TodoController(private val context: Context) {
    private val db = DBHelper(context, null)
    fun addTodoItem(todoName : String, status : String) {
        db.addTodoItem(todoName, status)
        Toast.makeText(context, " added to database", Toast.LENGTH_LONG).show()
    }

    fun todoList(): ArrayList<TodoModel> {
        return db.getTodoList();
    }
}