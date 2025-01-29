package com.example.sharedflowstateflowtutorial.usecase2

import com.example.sharedflowstateflowtutorial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class ChatRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var _incomingMessages = MutableSharedFlow<ChatMessage>(extraBufferCapacity = 64)
    val incomingMessages = _incomingMessages.asSharedFlow()

    init {
        simulateIncomingMessage()
    }

    fun sendMessage(username:String,content:String){
        coroutineScope.launch {
            _incomingMessages.emit(ChatMessage(username,content, R.drawable.ic_user))
        }
    }

    private fun simulateIncomingMessage() {
        coroutineScope.launch {
                delay(Random.nextLong(500,2000))
                val message = ChatMessage("User ${Random.nextInt(1,6)}","Hello, World!", R.drawable.ic_user)
                _incomingMessages.emit(message)
        }
    }
    fun cancel(){
        coroutineScope.cancel()
    }
}