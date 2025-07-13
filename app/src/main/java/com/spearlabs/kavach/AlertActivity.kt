package com.spearlabs.kavach.com.spearlabs.kavach
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.functions.FirebaseFunctions

class AlertActivity : AppCompatActivity() {

    private lateinit var functions: FirebaseFunctions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Functions
        functions = FirebaseFunctions.getInstance()

        // Use local emulator
        functions.useEmulator("10.0.2.2", 5001)

        // Call the function
        sendEmergencyAlert()
    }

    private fun sendEmergencyAlert() {
        val data = hashMapOf(
            "fcmTokens" to listOf("fakeToken1", "fakeToken2"),
            "latitude" to "28.6139",
            "longitude" to "77.2090",
            "senderEmail" to "test@example.com"
        )

        functions
            .getHttpsCallable("sendEmergencyAlert")
            .call(data)
            .addOnSuccessListener { result ->
                Log.d("FunctionSuccess", "Response: ${result.data}")
            }
            .addOnFailureListener { e ->
                Log.e("FunctionError", "Error: ${e.message}", e)
            }
    }
}

