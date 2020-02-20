package com.example.dicodingsubmissionapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weapon (
    var name: String = "",
    var type: String ="",
    var ammo: String ="",
    var range: String = "",
    var photo: Int = 0,
    var detail: String = "",
    var power: String = "",
    var stability: String ="",
    var firingrate: String = "",
    var description: String =""

):Parcelable
