package com.rohith.handleDeeplink.orderItem

import android.os.Parcel
import android.os.Parcelable

data class CustomDeeplinkModel(
        val name: String?
) : Parcelable {
        constructor(parcel: Parcel) : this(parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(name)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<CustomDeeplinkModel> {
                override fun createFromParcel(parcel: Parcel): CustomDeeplinkModel {
                        return CustomDeeplinkModel(parcel)
                }

                override fun newArray(size: Int): Array<CustomDeeplinkModel?> {
                        return arrayOfNulls(size)
                }
        }
}
