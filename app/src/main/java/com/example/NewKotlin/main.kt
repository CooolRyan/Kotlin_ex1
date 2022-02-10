package com.example.NewKotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class main : AppCompatActivity() {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment
        //mapFragment.getMapAsync(this)


        val rv1= findViewById<Button>(R.id.review1)
        val rv2= findViewById<Button>(R.id.review2)

        rv1.setOnClickListener {
            var intentrv1= Intent(applicationContext, review::class.java)
            startActivity(intentrv1)
        }

        rv2.setOnClickListener {
            var intentrv2= Intent(applicationContext, review2::class.java)
            startActivity(intentrv2)
        }
    }
}