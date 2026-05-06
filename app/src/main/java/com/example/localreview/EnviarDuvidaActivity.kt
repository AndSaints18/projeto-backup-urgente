package com.example.localreview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EnviarDuvidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_duvida)

        try {
            val btnVoltar = findViewById<Button>(R.id.btn_voltar_envio_duvida)
            val btnEnviar = findViewById<Button>(R.id.btn_enviar_duvida_final)
            val inputMensagem = findViewById<EditText>(R.id.input_duvida_texto)

            btnVoltar.setOnClickListener {
                finish()
            }

            btnEnviar.setOnClickListener {
                val mensagem = inputMensagem.text.toString().trim()

                // Validação de segurança
                if (mensagem.isEmpty()) {
                    inputMensagem.error = "A mensagem não pode estar vazia."
                    return@setOnClickListener
                }

                // UX de sucesso
                Toast.makeText(this, "Mensagem enviada! Retornaremos o contato em breve.", Toast.LENGTH_LONG).show()

                // Fecha a tela e volta
                finish()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao carregar o formulário.", Toast.LENGTH_SHORT).show()
        }
    }
}