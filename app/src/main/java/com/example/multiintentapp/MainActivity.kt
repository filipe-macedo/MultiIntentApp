package com.example.multiintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editPhoneNumber = findViewById<EditText>(R.id.editPhoneNumber)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val btnMakeCall = findViewById<Button>(R.id.btnMakeCall)
        val btnSendSMS = findViewById<Button>(R.id.btnSendSMS)
        val btnOpenMap = findViewById<Button>(R.id.btnOpenMap)
        val btnShareText = findViewById<Button>(R.id.btnShareText)

        // Abrir Navegador
        btnOpenBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }

        // Fazer Ligação
        btnMakeCall.setOnClickListener {
            val phone = editPhoneNumber.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phone")
            startActivity(intent)
        }

        // Enviar SMS
        btnSendSMS.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("sms:81999999999")
            intent.putExtra("sms_body", "Olá! Tudo bem?")
            startActivity(intent)
        }

        // Abrir Mapa (Recife)
        btnOpenMap.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-8.0476,-34.8770"))
            startActivity(intent)
        }

        // Compartilhar Texto
        btnShareText.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Olá, estou aprendendo Android!")
            startActivity(Intent.createChooser(intent, "Compartilhar via"))
        }
    }
}
