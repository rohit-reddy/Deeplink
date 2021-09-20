package com.rohith.handleDeeplink.deeplink

import android.content.Context
import com.example.deeplinkprocessor.DeeplinkHandler
import com.example.deeplinkprocessor.DeeplinkProcessor
import com.example.deeplinkprocessor.DefaultDeeplinkHandler
import com.rohith.handleDeeplink.productItem.ProductDetailsDeeplinkItem
import com.rohith.handleDeeplink.orderItem.OrderDetailsDeeplinkItem
import com.rohith.handleDeeplink.main.MainDeeplinkProcessor

class DeeplinkManager private constructor(private val context: Context) {

    private val processors: Set<DeeplinkProcessor> = hashSetOf(ProductDetailsDeeplinkItem(context),
    OrderDetailsDeeplinkItem(context),MainDeeplinkProcessor(context))

    fun providesDefaultDeeplinkHandler(): DeeplinkHandler = DefaultDeeplinkHandler(processors)


    companion object{
        var INSTANCE : DeeplinkManager? = null

        fun getInstance(context: Context) : DeeplinkManager {
            if(INSTANCE == null)
                INSTANCE = DeeplinkManager(context)
            return INSTANCE as DeeplinkManager
        }


    }
}