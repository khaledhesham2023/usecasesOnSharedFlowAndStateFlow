package com.example.sharedflowstateflowtutorial.usecase3

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class EventBus<T> {
    private var _events = MutableSharedFlow<T>()
    val events = _events.asSharedFlow()

    suspend fun sendEvent(event: T) {
        _events.emit(event)
    }
}