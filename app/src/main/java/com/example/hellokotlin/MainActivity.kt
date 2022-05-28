package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.TextView

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    var textToSpeech : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this,this)

        var message = findViewById<TextView>(R.id.tvHelloKotlin).text.toString()

    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.tvHelloKotlin).text = "Listo"
        }else{
            findViewById<TextView>(R.id.tvHelloKotlin).text = "No disponible"
        }
    }
}