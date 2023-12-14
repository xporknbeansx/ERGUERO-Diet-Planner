package com.dietplanner.erguero_finalproject

import android.os.Parcel
import android.os.Parcelable

data class Meal(
    val mealType: String,
    val ingredients: String,
    val nutritionalValues: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(mealType)
        parcel.writeString(ingredients)
        parcel.writeString(nutritionalValues)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Meal> {
        override fun createFromParcel(parcel: Parcel): Meal {
            return Meal(parcel)
        }

        override fun newArray(size: Int): Array<Meal?> {
            return arrayOfNulls(size)
        }
    }
}
