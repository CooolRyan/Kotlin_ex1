package com.example.NewKotlin
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


class LocalDB (context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int):
    SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db:SQLiteDatabase?){
        if (db!= null){
            //var sql:String ="CREATE TABLE if not exists localDB ("+ "NAME varchar(20)," + "ID varchar(20), " + "PASSWORD varchar(20),"+ "PASSWORD_OK varchar(20));"
            db.execSQL("CREATE TABLE localDB(NAME TEXT," +
                    "ID TEXT, PASSWORD TEXT, PASSWORD_OK TEXT);")
        }
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(
        name: String, id: String, password: String, password_ok: String) {
        var db: SQLiteDatabase = writableDatabase


        db.execSQL(
            "INSERT INTO localDB VALUES('" + name + "'" + ", '" + id + "'" + ", '" + password + "'" + ", '" + password_ok + "');"
        )
        db.close()

        /*
        val values=ContentValues().apply {
            put(name,name)
            put(id,id)
            put(password, password)
            put(password_ok,password_ok)
        }
        val A=db?.insert(LocalDB,null,values)

         */
    }

    fun Result(ID:String, PASSWORD:String):Boolean{
        var db:SQLiteDatabase=readableDatabase
        var result:String=""

        var cursor: Cursor = db.rawQuery("SELECT ID, PASSWORD FROM localDB", null)
        while (cursor.moveToNext()) {
            result = (cursor.getString(1))
            if (result.equals(ID)) {
                if (cursor.getString(2).equals(PASSWORD)) {
                    return true
                    break
                } else {
                    return false
                }
            }else {

            }
        }

        return false
    }





    /*
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
    */
}