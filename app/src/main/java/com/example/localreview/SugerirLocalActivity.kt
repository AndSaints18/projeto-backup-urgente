package com.example.localreview // Mantenha o seu pacote

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SugerirLocalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugerir_local)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_sugestao)
        val btnEnviar = findViewById<Button>(R.id.btn_enviar_sugestao)
        val inputNome = findViewById<EditText>(R.id.input_sugestao_nome)

        // Botão para voltar para a tela de análise
        btnVoltar.setOnClickListener {
            finish()
        }

        // Lógica de envio da sugestão
        btnEnviar.setOnClickListener {
            val nomeSugerido = inputNome.text.toString().trim()

            // Validação: Pelo menos o nome ele tem que dar!
            if (nomeSugerido.isEmpty()) {
                inputNome.error = "Por favor, insira o nome do local."
                return@setOnClickListener
            }

            // --- FUTURO: Aqui você enviaria os dados (Nome, Tipo, Bairro, Motivo) para o Banco de Dados (ex: Firebase) com o status "Pendente de Aprovação" ---

            // Feedback de sucesso com UX acolhedora
            Toast.makeText(this, "Obrigado! Sua sugestão foi enviada para os administradores.", Toast.LENGTH_LONG).show()

            // Fecha a tela e volta para a tela de criar análise
            finish()
        }
    }
}