package com.example.deeplinkprocessor

interface DeeplinkHandler {
    fun process(deeplink: String): Boolean
}
