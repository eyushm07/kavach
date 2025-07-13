package com.spearlabs.kavach.model

data class Emergency(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val timestamp: Long = 0L,
    val email: String? = null,
    val uid: String = ""
)
