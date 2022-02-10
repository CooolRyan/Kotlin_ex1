package com.example.NewKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class review : AppCompatActivity() {
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        Recycle()
    }

    private fun Recycle() {
        val re_pro = findViewById<RecyclerView>(R.id.rv1_profile)
        profileAdapter=ProfileAdapter(this)

        re_pro.adapter=profileAdapter

        datas.apply{
            add(ProfileData(img=1, name = "1번", content = "맛있어요"))
            add(ProfileData(img=2, name = "2번", content = "맛있없어요"))
            add(ProfileData(img=3, name = "3번", content = "그냥 그래요"))
            add(ProfileData(img=4, name = "4번", content = "다음에 또 올게요"))
            add(ProfileData(img=5, name = "5번", content = "내용 없음"))
            add(ProfileData(img=6, name = "6번", content = "그냥 그래요"))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()
        }

    }
}