package com.dimarco.hourstacker

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder

class UserDbManager {
    val dbVersion = 1
    val dbName = "UsersDatabase"
    val dbTable = "Users"
    private val colID = "ID"
    private val colName = "Name"

    /**
     * creating database variable
     * creating sql table
     */
    var sqlDB: SQLiteDatabase? = null
    val sqlCreateTable = "CREATE TABLE IF NOT EXISTS $dbTable ($colID INTEGER PRIMARY KEY AUTOINCREMENT, $colName VARCHAR(255));"

    /**
     * constructor to create a readable/writeable database
     */
    constructor(context: Context) {
        val db = DatabaseHelperUsers(context)
        sqlDB = db.writableDatabase
    }

    /**
     * User database helper
     * used to create and upgrade tables for new versions of the application
     */
    inner class DatabaseHelperUsers(context: Context) :
        SQLiteOpenHelper(context, dbName, null, dbVersion) {

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(sqlCreateTable)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS $dbTable")
        }

    }

    /**
     * function used to insert new users into the Users table
     */
    fun insert(values: ContentValues): Long {
        return sqlDB!!.insert(dbTable, "", values)
    }

    /**
     * function is used to delete existing Users from the database
     */
    fun delete(selection: String, selectionArgs: Array<String>): Int {
        return sqlDB!!.delete(dbTable, selection, selectionArgs)
    }

    /**
     * function is used to edit existing user information
     */
    fun edit(values: ContentValues, selection: String, selectionArgs: Array<String>): Int {
        return sqlDB!!.update(dbTable, values, selection, selectionArgs)
    }

    /**
     * function used to find existing users in the Users table
     */
    fun query(columns: Array<String>, selection: String, selectionArgs: Array<String>, sortOrder: String): Cursor {
        val qb = SQLiteQueryBuilder()
        qb.tables = dbTable

        return qb.query(sqlDB, columns, selection, selectionArgs, null,null, sortOrder)
    }




}