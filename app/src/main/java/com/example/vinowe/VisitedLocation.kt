package com.example.vinowe

import com.google.android.gms.maps.model.LatLng
import java.time.LocalDate

data class VisitedLocation(
    val name: String,
    val date: LocalDate,
    val latLng: LatLng
)

