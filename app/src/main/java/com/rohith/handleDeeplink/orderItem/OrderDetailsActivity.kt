package com.rohith.handleDeeplink.orderItem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.rohith.handleDeeplink.R
import com.rohith.handleDeeplink.databinding.ActivityOrderDetailsBinding


class OrderDetailsActivity: AppCompatActivity() {

    private lateinit var orderDetailsBinding: ActivityOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        println("onCreate(${javaClass.simpleName})")
        orderDetailsBinding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(orderDetailsBinding.root)

        intent.extras?.getString("EXTRA_NAME")?.let { name ->
            orderDetailsBinding.textTitle.text = "Hello, $name!"
        }

        orderDetailsBinding.btnBack.setOnClickListener {
            NavUtils.getParentActivityIntent(this)?.let { intent ->
                intent.component?.className?.let { print("Component Class: $it") }
                startActivity(intent)
            }
            super.onBackPressed()
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
