package com.brainasaservice.deeplinker.deeplink

import com.brainasaservice.deeplinker.ui.DeeplinkApp
import com.example.deeplinkprocessor.DeeplinkActivity
import com.example.deeplinkprocessor.DeeplinkHandler

class MyDeeplinkActivity : DeeplinkActivity() {
    override fun getDeeplinkHandler(): DeeplinkHandler = (applicationContext as DeeplinkApp).component.deeplinkHandler()
}
