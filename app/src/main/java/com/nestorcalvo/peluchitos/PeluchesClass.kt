package com.nestorcalvo.peluchitos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PeluchesClass(
    var ID:String,
    var nombre:String,
    var cantidad:Int,
    var precio:Int
):Parcelable

