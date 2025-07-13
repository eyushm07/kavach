package com.spearlabs.kavach.ui.main

import androidx.lifecycle.ViewModel
import com.spearlabs.kavach.data.repository.EmergencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val emergencyRepository: EmergencyRepository
) : ViewModel() {

    fun sendEmergency(data: Map<String, Any>, onComplete: (Boolean) -> Unit) {
        emergencyRepository.sendEmergencyAlert(data, onComplete)
    }
}
