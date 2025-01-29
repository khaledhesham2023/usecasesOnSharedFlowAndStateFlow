package com.example.sharedflowstateflowtutorial.usecase3

sealed class Event {
    data object EventA: Event()
    data object EventB: Event()
    data class EventC(val value: Int): Event()
}