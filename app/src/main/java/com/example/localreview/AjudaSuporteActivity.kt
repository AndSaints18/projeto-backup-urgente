package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AjudaSuporteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajuda_suporte)

        try {
            val btnVoltar = findViewById<Button>(R.id.btn_voltar_ajuda)
            val btnOutraDuvida = findViewById<Button>(R.id.btn_outra_duvida)

            btnVoltar.setOnClickListener {
                finish()
            }

            btnOutraDuvida.setOnClickListener {
                val intent = Intent(this, EnviarDuvidaActivity::class.java)
                startActivity(intent)
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao carregar a tela de suporte.", Toast.LENGTH_SHORT).show()
        }
    }
}