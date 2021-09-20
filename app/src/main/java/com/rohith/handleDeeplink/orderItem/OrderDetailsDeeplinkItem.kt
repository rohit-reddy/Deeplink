package com.rohith.handleDeeplink.orderItem

import android.content.Context
import android.content.Intent
import com.example.deeplinkprocessor.DeeplinkProcessor

class OrderDetailsDeeplinkItem  constructor(
        private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("deep/custom/")
    }

    override fun execute(deeplink: String) {
        val name = deeplink.removePrefix("deep://deep/custom/").split('/').getOrNull(0) ?: "Unknown"
        val model = CustomDeeplinkModel(name)

        context.startActivity(Intent(context, OrderDetailsActivity::class.java).apply {
            putExtra(DeeplinkProcessor.EXTRA_KEY, model)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }
}

