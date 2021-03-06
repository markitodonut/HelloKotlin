package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    var textToSpeech : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this,this)
        findViewById<Button>(R.id.buttonPlay).setOnClickListener{
            speak()
        }

    }

    private fun speak(){
        var message = findViewById<TextView>(R.id.etMessage).text.toString()
        if(message.isEmpty()) {
            findViewById<TextView>(R.id.tvServiceStatus).text = "Introduce un texto"
            message = "Introduce un texto"
        }
        textToSpeech!!.speak(message,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.tvServiceStatus).text = "Ready"
            textToSpeech!!.setLanguage(Locale("ES"))
        }else{
            findViewById<TextView>(R.id.tvServiceStatus).text = "No disponible"
        }
    }

    override fun onDestroy() {
        if (textToSpeech!=null) {
            textToSpeech!!.stop()
            textToSpeech!!.shutdown()
        }
        super.onDestroy()
    }
}