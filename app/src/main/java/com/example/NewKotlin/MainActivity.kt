package com.example.NewKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    //val DATABASE_VERSION = 1
    //val DATABASE_NAME = "LocalDB.db"
    private lateinit var binding: ActivityMainBinding
    private lateinit var localDB: LocalDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        localDB= LocalDB(this, "LocalDB.db", null, 1) // SQLite 모듈 생성

        binding.login.setOnClickListener { view->
            val id = binding.id.text.toString()
            val passwd = binding.password.text.toString()
            val exist = localDB.login(id,passwd) // 로그인 실행
            if(exist){ // 로그인 성공
                val intent =Intent(this,main::class.java)
                startActivity(intent)
            }else{ // 실패
                Toast.makeText(this@MainActivity, "아이디나 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.join.setOnClickListener { view->
            val intent =Intent(this,Register::class.java)
            startActivity(intent)
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