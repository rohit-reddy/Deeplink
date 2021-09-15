package com.rohith.handleDeeplink

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rohith.handleDeeplink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        handleIntent(intent)
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

                activityMainBinding.btnClaimOffer.setOnClickListener {
                    activityMainBinding.tvOfferClaimed.visibility = View.VISIBLE
                    activityMainBinding.btnClaimOffer.isEnabled = false
                }
            }else{
                activityMainBinding.discountGroup.visibility = View.GONE
            }
        }
    }
}