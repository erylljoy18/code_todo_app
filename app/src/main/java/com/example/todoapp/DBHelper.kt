package com.example.todoapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + TODO_ID + " INTEGER PRIMARY KEY, " +
                TODO_NAME + " TEXT," +
                TODO_STATUS + " TEXT" + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addTodoItem(todoName : String, status : String) {
        val values = ContentValues()

        values.put(TODO_NAME, todoName)
        values.put(TODO_STATUS, status)
        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun editTodoItem(id : Int, todoName : String, status : String) {
        val values = ContentValues()

        values.put(TODO_NAME, todoName)
        values.put(TODO_STATUS, status)
        val db = this.writableDatabase

        db.update(TABLE_NAME, values, "id=$id", arrayOf())
    }

    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    companion object{
        private const val DATABASE_NAME = "TODO_DB"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "todo_table"
        const val TODO_ID = "id"
        const val TODO_NAME = "todo_name"
        const val TODO_STATUS = "status"
    }
}