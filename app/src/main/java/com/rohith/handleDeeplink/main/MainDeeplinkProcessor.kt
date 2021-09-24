package com.rohith.handleDeeplink.main

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.deeplink.CustomLiveDataModel

class MainDeeplinkProcessor constructor(
        private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/main")
    }

    override fun execute(deeplink: String) {
        //CustomLiveDataModel.getInstance(context).changeState("${javaClass.canonicalName} Success")
        Intent().also { intent ->
            intent.action = "com.rohith.handleDeeplink.MY.DEEPLINK.HANDLE"
            intent.putExtra("Data", "${javaClass.canonicalName} Success")
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
        }
        context.startActivity(Intent(context, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
