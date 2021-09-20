package com.brainasaservice.deeplinker.deepcustom

import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.orderItem.OrderDetailsDeeplinkItem
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface DeepCustomModule {
    @Binds
    @IntoSet
    fun bindsDeepContentDeeplinkProcessorIntoSet(
        item: OrderDetailsDeeplinkItem
    ): DeeplinkProcessor
}
