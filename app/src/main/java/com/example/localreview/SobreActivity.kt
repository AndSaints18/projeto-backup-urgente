package com.example.localreview

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        try {
            val btnVoltar = findViewById<Button>(R.id.btn_voltar_sobre)

            btnVoltar.setOnClickListener {
                finish()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao carregar a tela Sobre.", Toast.LENGTH_SHORT).show()
        }
    }
}