package com.yago.architectcoders.data

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.yago.architectcoders.data.datasource.LocationDataSource
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class PlayServicesLocationDataSource(application: Application) : LocationDataSource {
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(application)

    @SuppressLint("MissingPermission")
    override suspend fun findLastLocation(): Pair<Double, Double>? =
        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation
                .addOnCompleteListener {
                    continuation.resume(it.result.toPair())
                }
        }

    private fun Location?.toPair(): Pair<Double, Double>? {
        val location = this?.let {
            Pair(it.latitude, it.longitude)
        }
        return location
    }
}
