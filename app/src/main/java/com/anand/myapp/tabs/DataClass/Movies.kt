package com.anand.myapp.tabs.DataClass

import android.os.Parcel
import android.os.Parcelable

data class Movies(
    val title: String,
    val year:Int,
    val cast:List<String>,
    val genres:List<String>
    ): Parcelable // we do this to move data from one activity to another.
    {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(year)
        parcel.writeStringList(cast)
        parcel.writeStringList(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movies> {
        override fun createFromParcel(parcel: Parcel): Movies {
            return Movies(parcel)
        }

        override fun newArray(size: Int): Array<Movies?> {
            return arrayOfNulls(size)
        }
    }
}