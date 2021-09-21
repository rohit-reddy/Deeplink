package com.rohith.handleDeeplink.productItem

import android.content.Context
import android.content.Intent
import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.DeeplinkApplication
import com.rohith.handleDeeplink.deeplink.CustomLiveDataModel


class ProductDetailsDeeplinkItem constructor(
        private val context: Context
) : DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean = deeplink.contains("deep/content")

    override fun execute(deeplink: String) {
        //set deeplink status
        CustomLiveDataModel.getInstance(context).changeState("${javaClass.canonicalName} Success")
        context.startActivity(Intent(context, ProductDetailsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}
