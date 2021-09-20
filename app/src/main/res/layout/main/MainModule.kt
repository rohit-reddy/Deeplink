package com.brainasaservice.deeplinker.main

import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.main.MainDeeplinkProcessor
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface MainModule {
    @Binds
    @IntoSet
    fun bindsMainDeeplinkProcessorIntoSet(
            processor: MainDeeplinkProcessor
    ): DeeplinkProcessor
}
