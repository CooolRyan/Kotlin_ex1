package com.example.NewKotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.NewKotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var editid : EditText
    lateinit var editpw : EditText
    lateinit var  sqlDB :SQLiteDatabase
   // lateinit var edtName:EditText
   // lateinit var edtNum:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loginBtn= findViewById<Button>(R.id.login) //null 참조 오류 -> xml 참조 후 실행하도록
        val joinBtn= findViewById<Button>(R.id.join)
        //val viewDB= findViewById<Button>(R.id.view)

        //edtName=findViewById(R.id.editNameResult)
        //edtNum=findViewById(R.id.editNumResult)

        editid= findViewById<EditText>(R.id.id)
        editpw= findViewById<EditText>(R.id.password)

        /*mbinding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)*/


        var localDB: LocalDB = LocalDB(applicationContext, "LocalDB.db", null, 1) // SQLite 모듈 생성

        loginBtn.setOnClickListener {
            val id=editid.text.toString()
            val pw=editpw.text.toString()
            if(localDB.Result(id,pw)==true){
                Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                var intentmain= Intent(applicationContext, main::class.java)
                startActivity(intentmain)
            }
            else{
                Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        /*
        viewDB.setOnClickListener {
            sqlDB=localDB.readableDatabase
            var cur:Cursor
            cur=sqlDB.rawQuery("SELECT * FROM localDB;", null)

            var strid="id"+"\r\n" + "------" + "\r\n"
            var strpw="pw"+"\r\n" + "------" + "\r\n"

            while(cur.moveToNext()){
                strid +=cur.getString(0) + "\r\n"
                strpw +=cur.getString(1) + "\r\n"
            }

            edtName.setText(strid)
            edtNum.setText(strpw)
        }


         */

        joinBtn.setOnClickListener {
            var intentregi= Intent(applicationContext, Register::class.java)
            startActivity(intentregi)
        }
    }


}


/*
class MainActivity :AppCompatActivity(){
    lateinit var button1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1=findViewById<Button>(R.id.login)

        button1.setOnClickListener {
            Toast.makeText(applicationContext,"버튼을 눌렀어요",Toast.LENGTH_SHORT).show()
        }
    }

    private fun createAccount(email:String, password:String){
        if(email.isNotEmpty()&&password.isNotEmpty()){

        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton:Button=findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice()}
    }
    private fun rollDice(){
        //Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
        val resultText:TextView=findViewById(R.id.result_text)
        resultText.text="My Text"
    }
}
*/