package com.bignerdranch.android.core3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Location(val city:String, val firstCoordinate:Float, val secondCoordinate: Float, val timezone:String) {

}