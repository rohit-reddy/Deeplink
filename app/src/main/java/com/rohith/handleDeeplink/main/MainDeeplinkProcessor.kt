package com.rohith.handleDeeplink.main

import android.content.Context
import android.content.Intent
import com.example.deeplinkprocessor.DeeplinkProcessor

class MainDeeplinkProcessor constructor(
        private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/main")
    }

    override fun execute(deeplink: String) {
        context.startActivity(Intent(context, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
