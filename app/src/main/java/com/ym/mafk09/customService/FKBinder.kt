package com.ym.mafk09.customService

import android.os.Binder
import android.os.Parcel
import android.os.Parcelable


class FKBinder() : Binder(), Parcelable {
    var fkService: MyService? =null

    constructor(parcel: Parcel) : this() {

    }

    fun setServer(fkService: MyService){
        this.fkService = fkService
    }

    fun setData(key:String,value:String){
        this.fkService?.setData(key,value)
    }




    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FKBinder> {
        override fun createFromParcel(parcel: Parcel): FKBinder {
            return FKBinder(parcel)
        }

        override fun newArray(size: Int): Array<FKBinder?> {
            return arrayOfNulls(size)
        }
    }
}