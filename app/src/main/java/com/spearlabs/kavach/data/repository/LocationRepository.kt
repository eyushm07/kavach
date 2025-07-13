package com.spearlabs.kavach.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.spearlabs.kavach.model.UserLocation
import javax.inject.Inject

class LocationRepository @Inject constructor(private val firestore: FirebaseFirestore) {

    fun updateLocation(uid: String, location: UserLocation) {
        firestore.collection("users_location").document(uid).set(location)
    }
}
