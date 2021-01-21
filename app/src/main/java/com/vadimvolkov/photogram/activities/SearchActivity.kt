package com.vadimvolkov.photogram.activities

import android.os.Bundle
import android.util.Log
import com.vadimvolkov.photogram.R
import com.vadimvolkov.photogram.views.setupBottomNavigation

class SearchActivity : MainActivity() {

    private val TAG = "SearchActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setupBottomNavigation(1)
        Log.d(TAG, "onCreate: ")
    }
}