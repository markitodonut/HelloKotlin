package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    var textToSpeech : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this,this)

    }

    private fun speak(){
        var message = findViewById<TextView>(R.id.tvHelloKotlin).text.toString()
        textToSpeech!!.speak(message,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.tvHelloKotlin).text = "Listo"
            textToSpeech!!.setLanguage(Locale.US)
        }else{
            findViewById<TextView>(R.id.tvHelloKotlin).text = "No disponible"
        }
    }
}