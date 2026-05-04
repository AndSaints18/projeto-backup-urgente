package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // 1. Encontrando os campos simples de texto (EditText)
        val inputNome = findViewById<EditText>(R.id.input_nome)
        val inputEmail = findViewById<EditText>(R.id.input_email_cadastro)
        val inputSenha = findViewById<EditText>(R.id.input_senha_cadastro)
        val inputConfirmarSenha = findViewById<EditText>(R.id.input_confirmar_senha)

        // 2. Encontrando os botões
        val btnCadastrar = findViewById<Button>(R.id.btn_realizar_cadastro)
        val btnJaTenhoConta = findViewById<Button>(R.id.btn_ja_tenho_conta)

        // Ação: Ir para Login se já tem conta
        btnJaTenhoConta.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Ação: Botão Cadastrar
        btnCadastrar.setOnClickListener {
            val nome = inputNome.text.toString().trim()
            val email = inputEmail.text.toString().trim()
            val senha = inputSenha.text.toString()
            val confirmarSenha = inputConfirmarSenha.text.toString()

            // Validação simples: campos vazios
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validação simples: senhas iguais
            if (senha != confirmarSenha) {
                // Ao invés do Toast, podemos colocar o erro direto no campo para ser mais claro
                inputConfirmarSenha.error = "As senhas não são iguais"
                return@setOnClickListener
            }

            // Sucesso!
            Toast.makeText(this, "Cadastro realizado!", Toast.LENGTH_SHORT).show()

            // Vai para o Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}