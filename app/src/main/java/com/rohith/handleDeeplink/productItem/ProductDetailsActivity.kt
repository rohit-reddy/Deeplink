package com.rohith.handleDeeplink.productItem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.rohith.handleDeeplink.databinding.ActivityProductDetailsBinding
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.util.Log
import androidx.lifecycle.Observer
import com.rohith.handleDeeplink.DeeplinkApplication
import com.rohith.handleDeeplink.R
import com.rohith.handleDeeplink.deeplink.CustomLiveDataModel


class ProductDetailsActivity : AppCompatActivity() {
    lateinit var prodcutDetailsBinding : ActivityProductDetailsBinding
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        println("onCreate(${javaClass.simpleName})")
        prodcutDetailsBinding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(prodcutDetailsBinding.root)

//        //observe deeplink
//        val deeplinkObserver = Observer<String> { status ->
//            Log.d(TAG, "Deeplink Status: $status")
//        }
//        (applicationContext as DeeplinkApplication).deeplinkManager.currentState.observe(this, deeplinkObserver)

        prodcutDetailsBinding.buttonBack.setOnClickListener {
            NavUtils.getParentActivityIntent(this)?.let { intent ->
                intent.component?.className?.let { print("Component Class: $it") }
                startActivity(intent)
            }
            super.onBackPressed()
        }

        prodcutDetailsBinding.btnOrderDtls.setOnClickListener {
            val intent = Intent(ACTION_VIEW, Uri.parse("deep://deep/custom/Rohit"))
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart(${javaClass.simpleName})")
    }

    override fun onStop() {
        super.onStop()
        println("onStop(${javaClass.simpleName})")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy(${javaClass.simpleName})")
    }
}
