package com.rohith.handleDeeplink.main

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.rohith.handleDeeplink.R
import com.rohith.handleDeeplink.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        FirebaseAnalytics.getInstance(this)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        handleIntent(intent)
        handleFirebaseDynamicLinks(intent)
    }


    private fun handleIntent(intent: Intent?){
        val appLinkAction: String? = intent?.action
        val appLinkData: Uri? = intent?.data
        showDeepLinkOffer(appLinkAction, appLinkData)
    }


    private fun showDeepLinkOffer(appLinkAction: String?, appLinkData: Uri?){
        if (Intent.ACTION_VIEW == appLinkAction && appLinkData != null){
            val promotionCode = appLinkData.getQueryParameter("code")
            if (promotionCode.isNullOrEmpty().not()){
                activityMainBinding.btnClaimOffer.isEnabled = true
                activityMainBinding.discountGroup.visibility = View.VISIBLE
                activityMainBinding.tvPromoCode.text = promotionCode
            }else{
                activityMainBinding.discountGroup.visibility = View.GONE
            }
        }
    }

    private fun handleFirebaseDynamicLinks(intent: Intent) {
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener { dynamicLinkData ->
                if (dynamicLinkData != null) {
                    showDynamicLinkOffer(dynamicLinkData.link)
                }
            }
            .addOnFailureListener(this) { e ->
                Log.d("DynamicLinkError", e.localizedMessage)
            }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { newIntent ->
            handleIntent(newIntent)
        }
    }



    private fun showDynamicLinkOffer(uri: Uri?) {
        val promotionCode = uri?.getQueryParameter("code")
        if (promotionCode.isNullOrBlank().not()) {
            activityMainBinding.btnClaimOffer.isEnabled = true
            activityMainBinding.discountGroup.visibility = View.VISIBLE
            activityMainBinding.tvPromoCode.text = promotionCode
        } else {
            activityMainBinding.discountGroup.visibility = View.GONE
        }
    }

    fun onClick(view: View) {
        when(view.id){
            activityMainBinding.btnBuy.id -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("deep://deep/content"))
                startActivity(intent)
            }

            activityMainBinding.btnClaimOffer.id ->{
                activityMainBinding.tvProductPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
                activityMainBinding.tvNewProductPrice.visibility = View.VISIBLE
                activityMainBinding.tvOfferClaimed.visibility = View.VISIBLE
                activityMainBinding.btnClaimOffer.isEnabled = false
                activityMainBinding.btnBuy.visibility = View.VISIBLE
            }
        }
    }


}