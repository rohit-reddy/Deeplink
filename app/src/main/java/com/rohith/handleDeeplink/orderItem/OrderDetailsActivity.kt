package com.rohith.handleDeeplink.orderItem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.lifecycle.Observer
import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.DeeplinkApplication
import com.rohith.handleDeeplink.R
import com.rohith.handleDeeplink.databinding.ActivityOrderDetailsBinding
import com.rohith.handleDeeplink.deeplink.CustomLiveDataModel


class OrderDetailsActivity: AppCompatActivity() {

    private lateinit var orderDetailsBinding: ActivityOrderDetailsBinding
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        println("onCreate(${javaClass.simpleName})")
        orderDetailsBinding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(orderDetailsBinding.root)



//        //observe deeplink
//        val deeplinkObserver = Observer<String> { status ->
//            Log.d(TAG, "Deeplink Status: $status")
//        }
//        (applicationContext as DeeplinkApplication).deeplinkManager.currentState.observe(this, deeplinkObserver)

        (intent.extras?.get(DeeplinkProcessor.EXTRA_KEY) as CustomDeeplinkModel).let {
            orderDetailsBinding.textTitle.text = "Hey ${it.name} !"
        }

        orderDetailsBinding.btnBack.setOnClickListener {
            NavUtils.getParentActivityIntent(this)?.let { intent ->
                intent.component?.className?.let { print("Component Class: $it") }
                startActivity(intent)
            }
            super.onBackPressed()
        }

        orderDetailsBinding.btnPlaceOrder.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("deep://deeplink/order/Rohit"))
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
