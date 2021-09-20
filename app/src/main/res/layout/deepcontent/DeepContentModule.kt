package com.brainasaservice.deeplinker.deepcontent

import com.example.deeplinkprocessor.DeeplinkProcessor
import com.rohith.handleDeeplink.productItem.ProductDetailsDeeplinkItem
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface DeepContentModule {
    @Binds
    @IntoSet
    fun bindsDeepContentDeeplinkProcessorIntoSet(
        item: ProductDetailsDeeplinkItem
    ): DeeplinkProcessor
}
