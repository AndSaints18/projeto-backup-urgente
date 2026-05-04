package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. Mapeando os elementos do XML
        val inputEmail = findViewById<EditText>(R.id.input_email)
        val inputSenha = findViewById<EditText>(R.id.input_senha)
        val btnEsqueciSenha = findViewById<Button>(R.id.btn_esqueci_senha)
        val btnFazerLogin = findViewById<Button>(R.id.btn_fazer_login)

        // 2. Ação do botão "Esqueci minha senha"
        btnEsqueciSenha.setOnClickListener {
            val intent = Intent(this, RecuperacaoActivity::class.java)
            startActivity(intent)
        }

        // 3. Ação do botão "Entrar"
        btnFazerLogin.setOnClickListener {
            val emailDigitado = inputEmail.text.toString().trim()
            val senhaDigitada = inputSenha.text.toString()

            // Validação para evitar que os campos fiquem vazios
            if (emailDigitado.isEmpty()) {
                inputEmail.error = "Preencha o e-mail"
                return@setOnClickListener
            }

            if (senhaDigitada.isEmpty()) {
                inputSenha.error = "Preencha a senha"
                return@setOnClickListener
            }

            // 4. Lógica de Autenticação Mockada
            if (emailDigitado == "narak@unifor.br" && senhaDigitada == "123") {
                // Sucesso! Mostra um aviso rápido e vai para a Seleção de Perfil
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, SelecaoPerfilActivity::class.java)
                startActivity(intent)

                // Opcional: Adicionamos o finish() para que, se o usuário apertar
                // o botão de "Voltar" no celular, ele não caia de volta na tela de login.
                finish()
            } else {
                // Falha! Credenciais erradas
                Toast.makeText(this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}