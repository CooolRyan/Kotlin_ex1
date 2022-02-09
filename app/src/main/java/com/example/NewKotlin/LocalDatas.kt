package com.example.NewKotlin
import android.provider.BaseColumns

object LocalDatas {
    object userData : BaseColumns{
        const val TABLE_NAME="user"
        const val COLUMN_NAME_NAME="name"
        const val COLUMN_NAME_ID="id"
        const val COLUMN_NAME_PASSWORD="password"
    }
    object Groups:BaseColumns{

    }
}