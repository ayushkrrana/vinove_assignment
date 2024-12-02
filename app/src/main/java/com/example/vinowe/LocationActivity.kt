package com.example.vinowe

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        // Initialize the map fragment
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragmentContainer) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Handle ImageButton click
        val locationButton: ImageButton = findViewById(R.id.buttonLocation)
        locationButton.setOnClickListener {
            val location = LatLng(37.7749, -122.4194) // Example location (San Francisco)
            moveToLocation(location)
        }
    }

    // This method is called when the map is ready to be used
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Set initial location (San Francisco)
        val initialLocation = LatLng(28.4909, 77.5096) // San Francisco coordinates
        map.addMarker(MarkerOptions().position(initialLocation).title("Marker in Gamma 2"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 10f))
    }

    // This function moves the camera to a new location on the map
    private fun moveToLocation(location: LatLng) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        map.addMarker(MarkerOptions().position(location).title("New Location"))
    }
}
