package com.example.localreview // Mantenha seu pacote

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Recuperacao2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacao2)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_login)
        val btnRedefinir = findViewById<Button>(R.id.btn_redefinir_senha)

        val inputToken = findViewById<EditText>(R.id.input_token)
        val inputNovaSenha = findViewById<EditText>(R.id.input_nova_senha)
        val inputConfirmaSenha = findViewById<EditText>(R.id.input_confirma_senha)

        // Botão para cancelar e voltar ao Login
        btnVoltar.setOnClickListener {
            finish() // Apenas fecha a tela atual, voltando para a anterior
        }

        // Lógica de Redefinição
        btnRedefinir.setOnClickListener {
            val token = inputToken.text.toString().trim()
            val novaSenha = inputNovaSenha.text.toString()
            val confirmaSenha = inputConfirmaSenha.text.toString()

            // 1. Valida se o Token tem 6 dígitos
            if (token.length < 6) {
                inputToken.error = "O código deve ter 6 dígitos"
                return@setOnClickListener
            }

            // 2. Valida se a senha tem um tamanho seguro
            if (novaSenha.length < 6) {
                inputNovaSenha.error = "A senha deve ter no mínimo 6 caracteres"
                return@setOnClickListener
            }

            // 3. Verifica se as senhas batem
            if (novaSenha != confirmaSenha) {
                inputConfirmaSenha.error = "As senhas não coincidem"
                return@setOnClickListener
            }

            // --- FUTURO: Aqui você enviaria o Token e a Nova Senha para o seu Banco de Dados ---

            // Tudo certo! Avisa o usuário e manda ele de volta pro Login
            Toast.makeText(this, "Senha redefinida com sucesso! Faça login.", Toast.LENGTH_LONG).show()

            // Navega para o Login (ajuste o nome da sua classe de Login se for diferente)
            val intent = Intent(this, LoginActivity::class.java)
            // Essa flag limpa a pilha, impedindo que o usuário aperte "voltar" e caia na tela de recuperação de novo
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}