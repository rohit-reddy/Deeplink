package com.example.deeplinkprocessor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData

abstract class DeeplinkActivity : AppCompatActivity() {
    var handleStatus = false
    var deeplinkData : String? = null

    abstract fun getDeeplinkHandler(): DeeplinkHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent?.let { handleIntent(it) }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { handleIntent(it) }
    }

    private fun handleIntent(intent: Intent) {
        intent.data?.toString()?.let {
            deeplinkData = it
            handleStatus = getDeeplinkHandler().process(it)
        }
    }
}
