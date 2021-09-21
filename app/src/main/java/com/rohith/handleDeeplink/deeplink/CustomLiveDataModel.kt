package com.rohith.handleDeeplink.deeplink

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CustomLiveDataModel(context: Context) {

    private val _currentState: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentState : LiveData<String> = _currentState


    fun changeState(state: String) {
        _currentState.value = state
    }

    companion object{
        private var mInstance: CustomLiveDataModel? = null

        fun getInstance(context: Context) : CustomLiveDataModel {
            if(mInstance == null)
                mInstance = CustomLiveDataModel(context)
            return mInstance as CustomLiveDataModel
        }
    }
}