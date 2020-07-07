package com.dimarco.hourstacker

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "HoursTrackerDB"
const val TABLE_NAME = "Users"
const val COLUMN_ID = "Id"
const val COLUMN_NAME = "Name"
const val COLUMN_BIRTHDAY = "Birthday"

class UserDatabaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable= "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME VARCHAR (256) NOT NULL, $COLUMN_BIRTHDAY DATE);"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COLUMN_NAME, user.name)
        cv.put(COLUMN_BIRTHDAY, user.birthday)

        var result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong()) {
            // Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show()
        } else {
            // Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

}