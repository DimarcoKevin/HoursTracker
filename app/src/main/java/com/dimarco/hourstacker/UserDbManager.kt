package com.dimarco.hourstacker

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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
    val sqlCreateTable = "CREATE TABLE IF NOT EXISTS $dbTable ($colID INTEGER PRIMARY KEY AUTOINCREMENT, $colName VARCHAR(255);"

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


}