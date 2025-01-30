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
                is Event.EventA -> handleEventA()
                is Event.EventB -> handleEventB()
                is Event.EventC -> handleEventC(event.value)
            }
        }.launchIn(scope)
    }

    private fun handleEventC(value: Int) {
        println("Event C emitted with value: $value")
    }

    private fun handleEventB() {
        println("Event B emitted")
    }

    private fun handleEventA() {
        println("Event A emitted")
    }
}