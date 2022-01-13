package com.example.todoapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.todoapp.model.TodoModel

class ListBaseAdapter(context: Context, private val dataSource: ArrayList<TodoModel>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder", "CutPasteId")
    override fun getView(p0: Int, convertView: View?, p2: ViewGroup?): View {
        val data = getItem(p0) as TodoModel
        val rowView = inflater.inflate(R.layout.list_item, p2, false)

        val todoName = rowView.findViewById(R.id.track_name) as TextView
        val todoStatus = rowView.findViewById(R.id.todoStatus) as TextView

        todoName.text = data.todoName
        todoStatus.text = data.todoStatus

        return rowView
    }
}