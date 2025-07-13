package com.spearlabs.kavach.data.repository

import com.google.firebase.functions.FirebaseFunctions
import javax.inject.Inject

class EmergencyRepository @Inject constructor(private val functions: FirebaseFunctions) {

    fun sendEmergencyAlert(data: Map<String, Any>, onComplete: (Boolean) -> Unit) {
        functions.getHttpsCallable("sendEmergencyAlert").call(data)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }
}
