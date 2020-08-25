package com.dimarco.hourstacker

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_job.*
import java.lang.Exception

class AddJob : AppCompatActivity() {

    /**
     * creating private values for each column in the Job table
     */
    private var id = 0
    private val name = "Name"
    private val title = "Title"
    private val wage = "Wage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user)

        var bundle= intent.extras
        try {
            id=bundle!!.getInt("ID")
            txtCompanyName.setText(bundle.getString("Name"))
            txtJobTitle.setText(bundle.getString("Title"))
            txtWage.setText(bundle.getString("Wage"))
        } catch(ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**
     * this will be called on click of the submit button
     * it creates a copy of the database manager
     * then puts the values into a ContentValues object
     * then inserts them into the Job database
     */
    fun submit(view: View) {
        var jobDbManager = JobDbManager(this)
        var values = ContentValues()
        values.put(name, txtCompanyName.text.toString())
        values.put(title, txtJobTitle.text.toString())
        values.put(wage, txtWage.text.toString())

        if (id == 0) {
            val id = jobDbManager.insert(values)

            if (id > 0) {
                Toast.makeText(this, "Job has been added.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Cannot add job.", Toast.LENGTH_LONG).show()
            }

        } else {
            var selectionArgs = arrayOf(id.toString())
            jobDbManager.edit(values, "ID=?", selectionArgs)

            if (id > 0) {
                Toast.makeText(this, "Job has been edited.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Cannot edit job.", Toast.LENGTH_LONG).show()
            }
        }
        //finish() // finish causes the app to crash
    }
}