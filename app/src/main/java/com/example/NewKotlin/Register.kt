package com.example.NewKotlin

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.NewKotlin.databinding.ActivityMainBinding

class Register : AppCompatActivity() {


        lateinit var edname :EditText
        lateinit var  edid: EditText
        lateinit var  edpassword: EditText
        lateinit var  edpassword_ok: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)

            edname=findViewById<EditText>(R.id.edit_name)
            edid=findViewById<EditText>(R.id.edit_id)
            edpassword=findViewById<EditText>(R.id.edit_pw)
            edpassword_ok=findViewById<EditText>(R.id.edit_pw_re)


            var localDB: LocalDB = LocalDB(this, "LocalDB",null, 1) // SQLite 모듈 생성

            var joinbtn=findViewById<Button>(R.id.btn_join)

            joinbtn.setOnClickListener {
                var name:String = edname.getText().toString()
                var id: String = edid.getText().toString()
                var password: String = edpassword.getText().toString()
                var password_ok: String = edpassword_ok.getText().toString()

                if(name.length==0 || id.length==0 || password.length==0 || password_ok.length==0){
                    Toast.makeText(applicationContext, "정보를 모두 입력하시오", Toast.LENGTH_SHORT).show()
                }
                else{
                    localDB.insert(name, id, password, password_ok)
                    Toast.makeText(applicationContext, "회원가입 완료", Toast.LENGTH_SHORT).show()
                    var intentmain= Intent(applicationContext, MainActivity::class.java)
                    startActivity(intentmain)
                }
            }

        }


}