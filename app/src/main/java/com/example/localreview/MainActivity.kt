package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Encontrando os botões do XML através dos IDs
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)


        btnEntrar.setOnClickListener {
            // Cria a intenção de ir da MainActivity para a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnCadastrar.setOnClickListener {
            // Cria a intenção de ir da MainActivity para a CadastroActivity
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}