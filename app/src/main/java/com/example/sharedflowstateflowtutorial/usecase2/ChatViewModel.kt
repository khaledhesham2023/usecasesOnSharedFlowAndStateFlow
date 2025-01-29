package com.example.sharedflowstateflowtutorial.usecase2

import androidx.lifecycle.ViewModel

class ChatViewModel(private val chatRepository: ChatRepository) : ViewModel() {
    val incomingMessages = chatRepository.incomingMessages

    fun sendMessage(username: String, content: String) =
        chatRepository.sendMessage(username, content)

}