package com.example.todoapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.todoapp.ListBaseAdapter
import com.example.todoapp.MainActivity
import com.example.todoapp.R
import com.example.todoapp.model.TodoModel

class TodoListFragment : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.todo_list_fragment, container, false)
        val todoListView = view.findViewById<ListView>(R.id.todoList)
        val adapter = ListBaseAdapter(requireActivity(), (activity as MainActivity?)!!.getList())
        val list : ArrayList<TodoModel> = (activity as MainActivity?)!!.getList()
        todoListView.adapter = adapter
        return view;
    }
}