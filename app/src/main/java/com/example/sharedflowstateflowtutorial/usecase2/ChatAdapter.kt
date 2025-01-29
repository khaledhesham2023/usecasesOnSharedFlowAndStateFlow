package com.example.sharedflowstateflowtutorial.usecase2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedflowstateflowtutorial.R

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private val messages = mutableListOf<ChatMessage>()

    class ChatViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        private val sender: TextView = itemView.findViewById(R.id.chat_sender)
        private val content: TextView = itemView.findViewById(R.id.chat_content)
        private val icon: ImageView = itemView.findViewById(R.id.user_image)

        fun bind(chatMessage: ChatMessage){
            sender.text = chatMessage.sender
            content.text = chatMessage.content
            icon.setImageResource(chatMessage.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message,parent,false))
    }

    override fun getItemCount(): Int  = messages.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    fun addMessages(message: ChatMessage){
        messages.add(message)
        notifyItemInserted(messages.size -1)
    }
}