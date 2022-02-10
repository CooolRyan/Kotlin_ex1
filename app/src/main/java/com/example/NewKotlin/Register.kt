package com.example.NewKotlin

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.NewKotlin.databinding.ActivityMainBinding

class Register : AppCompatActivity() {



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)


            var localDB: LocalDB = LocalDB(this, "LocalDB",null, 1) // SQLite 모듈 생성

            var joinbtn=findViewById<Button>(R.id.btn_join)

            joinbtn.setOnClickListener {
                var name:String = name.getText().toString()
                var id: String = id.getText().toString()
                var password: String = password.getText().toString()
                var password_ok: String = password_ok.getText().toString()
            }

        }


}