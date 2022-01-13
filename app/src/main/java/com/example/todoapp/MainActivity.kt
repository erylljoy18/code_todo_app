package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.todoapp.model.TodoModel
import com.example.todoapp.presenter.TodoController
import com.example.todoapp.views.AddTodoFragment
import com.example.todoapp.views.TodoListFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("Add Todo"))
        tabLayout.addTab(tabLayout.newTab().setText("List"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    fun addTodoItem(todoName : String, todoStatus : String){
        TodoController(this).addTodoItem(todoName, todoStatus)
    }

    fun getList() : ArrayList<TodoModel> {
        Log.d("ThisIsCalled", "True");
        return TodoController(this).todoList()
    }
}

@Suppress("DEPRECATION")
internal class MyAdapter(
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> { AddTodoFragment() }
            1 -> { TodoListFragment() }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}