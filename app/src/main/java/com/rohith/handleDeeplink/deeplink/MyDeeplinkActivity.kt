package com.rohith.handleDeeplink.deeplink

import com.example.deeplinkprocessor.DeeplinkActivity
import com.example.deeplinkprocessor.DeeplinkHandler
import com.rohith.handleDeeplink.DeeplinkApplication

class MyDeeplinkActivity : DeeplinkActivity() {
    override fun getDeeplinkHandler(): DeeplinkHandler = (applicationContext as DeeplinkApplication).deeplinkManager.providesDefaultDeeplinkHandler()
}
