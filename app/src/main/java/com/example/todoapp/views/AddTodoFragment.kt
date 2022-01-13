package com.example.todoapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.todoapp.MainActivity
import com.example.todoapp.R

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
            (activity as MainActivity?)!!
                .addTodoItem(todoName.text.toString(), todoStatus.text.toString())
        }

        return view;
    }
}