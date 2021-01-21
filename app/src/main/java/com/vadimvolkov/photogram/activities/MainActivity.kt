package com.vadimvolkov.photogram.activities

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vadimvolkov.photogram.utils.showToast


abstract class MainActivity : AppCompatActivity() {

    protected lateinit var commonViewModel: CommonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        commonViewModel = ViewModelProvider(this).get(CommonViewModel::class.java)
        commonViewModel.errorMessage.observe(this, Observer {
            it?.let {
                showToast(it)
            }
        })
    }

    protected inline fun <reified T: ViewModel> initViewModel(): T =
        ViewModelProvider(this, ViewModelFactory(commonViewModel))
            .get(T::class.java)

    companion object {
        const val TAG = "MainActivity"
    }
}