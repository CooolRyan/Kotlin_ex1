package com.example.NewKotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(private val context: Context) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    var datas = mutableListOf<ProfileData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val Name: TextView = itemView.findViewById(R.id.reviewname)
        private val Content: TextView = itemView.findViewById(R.id.reviewcontent)
        private val Img: ImageView = itemView.findViewById(R.id.reviewimage)

        fun bind(item: ProfileData) {
            Name.text = item.name
            Content.text = item.content.toString()
            //Img.with(itemView).load(item.img).into(imgProfile)

        }
    }


}