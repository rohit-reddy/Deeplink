package com.rohith.handleDeeplink.deeplink

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.deeplinkprocessor.DeeplinkActivity
import com.example.deeplinkprocessor.DeeplinkHandler
import com.rohith.handleDeeplink.DeeplinkApplication
import com.rohith.handleDeeplink.R

class MyDeeplinkActivity : DeeplinkActivity() {
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

//        //observe deeplink
//        val deeplinkObserver = Observer<String> { status ->
//            Log.d(TAG, "Deeplink Status: $status")
//            Toast.makeText(this, "Deeplink Status: $status", Toast.LENGTH_LONG).show()
//        }
//        CustomLiveDataModel.getInstance(this).currentState.observe(this, deeplinkObserver)
//
        if (!handleStatus){
            CustomLiveDataModel.getInstance(this).changeState("Failed !! for deeplink $deeplinkData")
        }
        finish()
    }

    override fun getDeeplinkHandler(): DeeplinkHandler = (applicationContext as DeeplinkApplication).deeplinkManager.providesDefaultDeeplinkHandler()
}
