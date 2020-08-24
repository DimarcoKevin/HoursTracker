package com.dimarco.hourstacker

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_user.*
import java.lang.Exception

class AddUser : AppCompatActivity() {

    /**
     * creating private values for each column in the User table
     */
    private val user = "User"
    private var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user)

        var bundle= intent.extras
        try {
            id=bundle!!.getInt("ID")
            txtName.setText(bundle.getString("User"))
        } catch(ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**
     * this will be called on click of the submit button
     * it creates a copy of the database manager
     * then puts the values into a ContentValues object
     * then inserts them into the User database
     */
    fun submit(view: View) {
        var userDbManager = UserDbManager(this)
        var values = ContentValues()
        values.put(user, txtName.text.toString())

        if (id == 0) {
            val id = userDbManager.insert(values)

            if (id > 0) {
                Toast.makeText(this, "User has been added.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Cannot add user.", Toast.LENGTH_LONG).show()
            }

        } else {
            var selectionArgs = arrayOf(id.toString())
            userDbManager.edit(values, "ID=?", selectionArgs)

            if (id > 0) {
                Toast.makeText(this, "User has been edited.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Cannot edit user.", Toast.LENGTH_LONG).show()
            }
        }
        //finish() // finish causes the app to crash
    }
}