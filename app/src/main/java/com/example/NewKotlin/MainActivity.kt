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
import kotlin

class MainActivity : AppCompatActivity() {

    private var mbinding:ActivityMainBinding?=null
    private val binding get()= mbinding!!

    var loginBtn=findViewById<Button>(R.id.login)
    var joinBtn=findViewById<Button>(R.id.join)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mbinding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var localDB: LocalDB = LocalDB(applicationContext, "LocalDB.db", null, 1) // SQLite 모듈 생성

        loginBtn.setOnClickListener {
            val id=binding.id.text.toString()
            val pw=binding.password.text.toString()
            if(localDB.Result(bind.id.getText().toString(), bind.password.getText().toString())==true){
                Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                var intentmain= Intent(applicationContext, main::class.java)
                startActivity(intentmain)
            }
            else{
                Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        joinBtn.setOnClickListener {
            var intentregi= Intent(applicationContext, Register::class.java)
            startActivity(intentregi)
        }
    }


    override fun onDestroy() {// 엑티비티가 종료시 close
        localDB.close()
        super.onDestroy()
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