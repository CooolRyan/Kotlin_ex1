package com.example.NewKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class review2 : AppCompatActivity() {
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        Recycle()
    }

    private fun Recycle() {
        val re_pro = findViewById<RecyclerView>(R.id.rv2_profile)
        profileAdapter=ProfileAdapter(this)

        re_pro.adapter=profileAdapter

        datas.apply{
            add(ProfileData(img=1, name = "a번", content = "별로"))
            add(ProfileData(img=2, name = "b번", content = "굿"))
            add(ProfileData(img=3, name = "c번", content = "돈 값 함"))
            add(ProfileData(img=4, name = "d번", content = "여긴 비추"))
            add(ProfileData(img=5, name = "e번", content = "번창하세요"))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()
        }

    }
}