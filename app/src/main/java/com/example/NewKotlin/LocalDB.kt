package com.example.NewKotlin
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class LocalDB {

    override fun onCreate(db:SQLiteDatabase?){
        if (db!= null){
            createDatabase(db)
        }
    }

    fun createDatabase(db:SQLiteDatabase){
        var sql:String ="CREATE TABLE if not exists ${LocalDatas.userData.TABLE_NAME} ("+ "${BaseColumns._ID} integer primary key autoincrement, " + "${LocalDatas.userData.COLUMN_NAME_NAME} varchar(20)," + "${LocalDatas.userData.COLUMN_NAME_ID} varchar(20), " + "${LocalDatas.userData.COLUMN_NAME_PASSWORD} varchar(20)"+ ");"

        db.execSQL(sql)
    }

    fun register(name:String, id:String, password:String){
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues().apply {
            put(LocalDatas.userData.COLUMN_NAME_NAME, name)
            put(LocalDatas.userData.COLUMN_NAME_ID, id)
            put(LocalDatas.userData.COLUMN_NAME_PASSWORD, password)
        }
        val newRowId = db?.insert(LocalDatas.userData.TABLE_NAME, null, values)

    }
    
    fun login(id:String, password: String):Boolean{
        val db = this.readableDatabase

        val projection = arrayOf(BaseColumns._ID)
        val selection = "${LocalDatas.userData.COLUMN_NAME_ID} = ? AND ${LocalDatas.userData.COLUMN_NAME_PASSWORD} = ?"
        val selectionArgs = arrayOf(id,password)

        val cursor = db.query(
            LocalDatas.userData.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        if(cursor.count>0) return true;
        else return false;

        
    }
}