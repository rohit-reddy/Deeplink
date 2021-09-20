package com.brainasaservice.deeplinker.main

import android.content.Context
import android.content.Intent
import com.example.deeplinkprocessor.DeeplinkProcessor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainDeeplinkProcessor @Inject constructor(
        private val context: Context
) : DeeplinkProcessor {
    override fun process(deeplink: String): Boolean {
        println("${this::class.java} processing $deeplink")

        if (deeplink.contains("/main")) {
            context.startActivity(Intent(context, MainActivity::class.java))
            return true
        }
        return false
    }
}
