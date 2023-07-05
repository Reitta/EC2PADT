package com.example.ec2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val location1 = LatLng(-12.091, -77.036)
        val location2 = LatLng(-12.083, -77.045)
        val location3 = LatLng(-12.097, -77.031)

        googleMap.addMarker(MarkerOptions().position(location1).title("Ubicación 1"))
        googleMap.addMarker(MarkerOptions().position(location2).title("Ubicación 2"))
        googleMap.addMarker(MarkerOptions().position(location3).title("Ubicación 3"))

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location1))
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12f))
    }
}

