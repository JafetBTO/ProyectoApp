package com.example.proyectoapp.view

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoapp.R

import com.mapbox.maps.*


var mapView: MapView? = null


class Mapa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)
        mapView = findViewById(R.id.mapView)
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
    }
}
