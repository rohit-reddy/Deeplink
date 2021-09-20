package com.rohith.handleDeeplink

import android.app.Application
import com.rohith.handleDeeplink.deeplink.DeeplinkManager

class DeeplinkApplication : Application() {
    val deeplinkManager : DeeplinkManager by lazy {
        DeeplinkManager.getInstance(this)
    }

    override fun onCreate() {
        super.onCreate()

    }
}