package com.dimarco.hourstacker

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder

class JobDbManager {
    val dbVersion = 1
    val dbName = "JobsDatabase"
    val dbTable = "Job"
    private val colID = "ID"
    private val colName = "Name"
    private val colTitle = "Title"
    private val colWage = "Wage"


    /**
     * creating database variable
     * creating sql table
     */
    var sqlDB: SQLiteDatabase? = null
    val sqlCreateTable = "CREATE TABLE IF NOT EXISTS $dbTable " +
            "($colID INTEGER PRIMARY KEY AUTOINCREMENT, $colName VARCHAR(255), " +
            "$colTitle VARCHAR(255), $colWage FLOAT);"

    /**
     * constructor to create a readable/writeable database
     */
    constructor(context: Context) {
        val db = DatabaseHelperJobs(context)
        sqlDB = db.writableDatabase
    }

    /**
     * Job database helper
     * used to create and upgrade tables for new versions of the application
     */
    inner class DatabaseHelperJobs(context: Context) :
        SQLiteOpenHelper(context, dbName, null, dbVersion) {

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(sqlCreateTable)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS $dbTable")
        }

    }

    /**
     * function used to insert new jobs into the Jobs table
     */
    fun insert(values: ContentValues): Long {
        return sqlDB!!.insert(dbTable, "", values)
    }

    /**
     * function is used to delete existing Jobs from the database
     */
    fun delete(selection: String, selectionArgs: Array<String>): Int {
        return sqlDB!!.delete(dbTable, selection, selectionArgs)
    }

    /**
     * function is used to edit existing Job information
     */
    fun edit(values: ContentValues, selection: String, selectionArgs: Array<String>): Int {
        return sqlDB!!.update(dbTable, values, selection, selectionArgs)
    }

    /**
     * function used to find existing jobs in the Jobs table
     */
    fun query(columns: Array<String>, selection: String, selectionArgs: Array<String>, sortOrder: String): Cursor {
        val qb = SQLiteQueryBuilder()
        qb.tables = dbTable

        return qb.query(sqlDB, columns, selection, selectionArgs, null,null, sortOrder)
    }




}