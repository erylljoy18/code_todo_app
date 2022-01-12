package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddTodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_todo_fragment, container, false)
        val todoName = view.findViewById<EditText>(R.id.todoName)
        val todoStatus = view.findViewById<EditText>(R.id.todoStatus)
        val btn = view.findViewById<Button>(R.id.addBtn)

        btn.setOnClickListener{
            Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show()
        }

        return view;
    }
}