package com.rohith.handleDeeplink.main

import android.content.Context
import android.content.Intent
import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.deeplink.CustomLiveDataModel

class MainDeeplinkProcessor constructor(
        private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/main")
    }

    override fun execute(deeplink: String) {
        CustomLiveDataModel.getInstance(context).changeState("${javaClass.canonicalName} Success")
        context.startActivity(Intent(context, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
