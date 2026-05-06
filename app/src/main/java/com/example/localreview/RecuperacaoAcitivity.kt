package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecuperacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacao_acitivity)

        // Encontrando os elementos na tela
        val inputEmail = findViewById<EditText>(R.id.input_email_recuperacao)
        val btnEnviar = findViewById<Button>(R.id.btn_enviar_recuperacao)

        // Ação do botão "Enviar"
        btnEnviar.setOnClickListener {
            val email = inputEmail.text.toString().trim()

            // Validação simples
            if (email.isEmpty()) {
                inputEmail.error = "Por favor, digite seu e-mail"
                return@setOnClickListener
            }

            // Simula o envio do token/link de recuperação
            Toast.makeText(this, "Instruções de recuperação enviadas para $email", Toast.LENGTH_LONG).show()

            // Redireciona de volta para a MainActivity
            val intent = Intent(this, Recuperacao2Activity::class.java)

            // Adiciona flags para evitar que a MainActivity seja duplicada na memória do celular
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)

            // Fecha a tela de recuperação
            finish()
        }
    }
}