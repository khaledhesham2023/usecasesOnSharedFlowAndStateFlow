package com.example.sharedflowstateflowtutorial

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedflowstateflowtutorial.usecase1.StockViewModel
import com.example.sharedflowstateflowtutorial.usecase2.ChatAdapter
import com.example.sharedflowstateflowtutorial.usecase2.ChatRepository
import com.example.sharedflowstateflowtutorial.usecase2.ChatViewModel
import com.example.sharedflowstateflowtutorial.usecase3.Event
import com.example.sharedflowstateflowtutorial.usecase3.EventBus
import com.example.sharedflowstateflowtutorial.usecase3.EventListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    // usecase 1 : StateFlow as LiveData
//    private val stockViewModel = StockViewModel()

//    // usecase 2 : SharedFlow in Chatting App
//    private val chatViewModel: ChatViewModel = ChatViewModel(ChatRepository())
//    private var chatAdapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // usecase 1 : StateFlow as LiveData
//        val stockTextView = findViewById<TextView>(R.id.stockPriceTextView)
//
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                stockViewModel.stockPrice.collect { price ->
//                    stockTextView.text = "Stock Price: $price"
//                }
//            }
//        }

        // usecase 2 : SharedFlow in Chatting App
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        val fab = findViewById<FloatingActionButton>(R.id.button_add)
//        val et = findViewById<EditText>(R.id.et)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = chatAdapter
//        fab.setOnClickListener {
//            if (et.text.toString().isNotEmpty()){
//                chatViewModel.sendMessage("Khaled",et.text.toString().trim())
//            } else {
//                et.error = "No entry"
//            }
//        }
//        lifecycleScope.launch {
//            chatViewModel.incomingMessages.collect { message ->
//                chatAdapter.addMessages(message)
//                recyclerView.scrollToPosition(chatAdapter.itemCount - 1)
//            }
//        }
    }
}

fun main() = runBlocking {
    val eventBus = EventBus<Event>()
    val eventListener = EventListener(eventBus, this)
    launch(Dispatchers.Default) {
        delay(1000)
        eventBus.sendEvent(Event.EventA)

        delay(1000)
        eventBus.sendEvent(Event.EventB)

        delay(1000)
        eventBus.sendEvent(Event.EventC(42))
    }

    delay(5000)
}