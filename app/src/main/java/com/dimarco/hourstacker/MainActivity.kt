package com.dimarco.hourstacker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    /**
     * creating the array list for all the job
     */
    private var jobList = ArrayList<Job>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /**
     * creating a search query method
     * this method will search by company name, or by all if nothing is chosen
     * it will iterate over all rows in the database that fit that title
     * and then return them in note form styling
     */
    private fun loadJobQuery(title: String) {


    }

}
