package com.rohith.handleDeeplink

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.rohith.handleDeeplink.deeplink.DeeplinkManager
import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicBoolean


class DeeplinkApplication : Application(), ActivityLifecycleCallbacks {
    val deeplinkManager : DeeplinkManager by lazy {
        DeeplinkManager.getInstance(this)
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    private fun determineForegroundStatus() {
        if (applicationBackgrounded.get()) {
            onEnterForeground()
            applicationBackgrounded.set(false)
        }
    }

    private fun determineBackgroundStatus() {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            if (!applicationBackgrounded.get() && currentActivityReference == null) {
                applicationBackgrounded.set(true)
                onEnterBackground()
            }
        }, INTERVAL_BACKGROUND_STATE_CHANGE)
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivityReference = WeakReference(activity)
        determineForegroundStatus()
    }

    override fun onActivityPaused(activity: Activity) {
        currentActivityReference = null
        determineBackgroundStatus()
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        // if you want to do something when every activity is created, do it here
    }

    override fun onActivityStarted(activity: Activity) {
        // if you want to do something when every activity is started, do it here
    }

    override fun onActivityStopped(activity: Activity) {
        // if you want to do something when every activity is stopped, do it here
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        // if you want to do something when an activity saves its instance state, do it here
    }

    override fun onActivityDestroyed(activity: Activity) {
        // if you want to do something when every activity is destroyed, do it here
    }

    companion object {
        private val TAG = DeeplinkApplication::class.java.simpleName
        private val applicationBackgrounded: AtomicBoolean = AtomicBoolean(true)
        private const val INTERVAL_BACKGROUND_STATE_CHANGE = 750L
        private var currentActivityReference: WeakReference<Activity>? = null
        fun onEnterForeground() {
            //This is where you'll handle logic you want to execute when your application enters the foreground
            Log.d(TAG, "onEnterForeground: ")
        }

        fun onEnterBackground() {
            //This is where you'll handle logic you want to execute when your application enters the background
            Log.d(TAG, "onEnterBackground: ")
        }
    }
}