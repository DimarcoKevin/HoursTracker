package com.dimarco.hourstacker

import android.os.Bundle
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
}