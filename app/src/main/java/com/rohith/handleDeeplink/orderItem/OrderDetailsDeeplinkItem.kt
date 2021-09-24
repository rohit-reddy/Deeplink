package com.rohith.handleDeeplink.orderItem

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.DeeplinkApplication
import com.rohith.handleDeeplink.deeplink.CustomLiveDataModel

class OrderDetailsDeeplinkItem  constructor(
        private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("deep/custom/")
    }

    override fun execute(deeplink: String) {
        val name = deeplink.removePrefix("deep://deep/custom/").split('/').getOrNull(0) ?: "Unknown"
        val model = CustomDeeplinkModel(name)

        //set deeplink status
        //CustomLiveDataModel.getInstance(context).changeState("${javaClass.canonicalName} Success")
        Intent().also { intent ->
            intent.action = "com.rohith.handleDeeplink.MY.DEEPLINK.HANDLE"
            intent.putExtra("Data", "${javaClass.canonicalName} Success")
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
        }
        context.startActivity(Intent(context, OrderDetailsActivity::class.java).apply {
            putExtra(DeeplinkProcessor.EXTRA_KEY, model)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }
}

