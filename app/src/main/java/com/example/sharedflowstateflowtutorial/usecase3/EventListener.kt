package com.example.sharedflowstateflowtutorial.usecase3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class EventListener(
    private val eventBus: EventBus<Event>,
    private val scope: CoroutineScope
) {
    init {
        eventBus.events.onEach { event ->
            when (event) {
                is Event.EventA -> {
                    handleEventA()
                }

                is Event.EventB -> {
                    handleEventB()
                }

                is Event.EventC -> {
                    handleEventC(event.value)
                }
            }
        }.launchIn(scope)
    }

    private fun handleEventA() {
        println("EventA received")
    }

    private fun handleEventB() {
        println("EventB received")

    }

    private fun handleEventC(value: Int) {
        println("EventC received with value: $value")

    }
}