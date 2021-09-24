package com.rohith.handleDeeplink.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


class MyBroadcastReceiver : BroadcastReceiver() {
    private val TAG = javaClass.simpleName
    var activityListener: IDeeplinkListerner? = null

    fun setDeeplinkHandleListener(listener: IDeeplinkListerner?) {
        activityListener = listener
    }

    override fun onReceive(context: Context?, intent: Intent) {
        Log.d(TAG, "BroadcastReceiver onReceive() CALLED")
        if (intent.action.equals("com.rohith.handleDeeplink.MY.DEEPLINK.HANDLE", ignoreCase = true)) {
            StringBuilder().apply {
                append("Action: ${intent.action}\n")
                append("Data: ${intent.extras?.get("Data")}\n")
                toString().also { log ->
                    activityListener?.canHandle(log)
                    //Log.d(TAG, log)
                    //Toast.makeText(context, log, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}