package com.rohith.handleDeeplink.productItem

import android.content.Context
import android.content.Intent
import com.example.deeplinkprocessor.DeeplinkProcessor


class ProductDetailsDeeplinkItem constructor(
        private val context: Context
) : DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean = deeplink.contains("deep/content")

    override fun execute(deeplink: String) {
        context.startActivity(Intent(context, ProductDetailsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
