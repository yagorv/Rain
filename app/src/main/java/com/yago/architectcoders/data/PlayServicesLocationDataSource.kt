package com.yago.architectcoders.data

import android.annotation.SuppressLint
import android.app.Application
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.yago.architectcoders.data.datasource.LocationDataSource
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.*
import kotlin.coroutines.resume


class PlayServicesLocationDataSource(private val application: Application) : LocationDataSource {
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(application)

    @SuppressLint("MissingPermission")
    override suspend fun findLastLocation(): Pair<Double, Double>? =
        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation
                .addOnCompleteListener {
                    continuation.resume(it.result.toPair())
                }
        }

    suspend fun getCountryLocation(): String {
        val geocoder = Geocoder(application, Locale.getDefault())
        findLastLocation()?.let {
            val addresses = geocoder.getFromLocation(it.first, it.second, 1)
            return addresses[0].locality
        }
        return ""
    }

    private fun Location?.toPair(): Pair<Double, Double>? {
        val location = this?.let {
            Pair(it.latitude, it.longitude)
        }
        return location
    }
}
