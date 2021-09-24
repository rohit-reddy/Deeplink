package com.rohith.handleDeeplink.broadcast

interface IDeeplinkListerner {

    fun canHandle(status: String): Boolean
}