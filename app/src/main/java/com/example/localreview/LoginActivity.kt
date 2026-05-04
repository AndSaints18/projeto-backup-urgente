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

        val inputEmail = findViewById<EditText>(R.id.input_email)
        val inputSenha = findViewById<EditText>(R.id.input_senha)
        val btnEsqueciSenha = findViewById<Button>(R.id.btn_esqueci_senha)
        val btnFazerLogin = findViewById<Button>(R.id.btn_fazer_login)

        // "Esqueci minha senha"
        btnEsqueciSenha.setOnClickListener {
            val intent = Intent(this, RecuperacaoActivity::class.java)
            startActivity(intent)
        }

        // Ação do botão "Entrar"
// 3. Ação do botão "Entrar"
        btnFazerLogin.setOnClickListener {
            val emailDigitado = inputEmail.text.toString().trim()
            val senhaDigitada = inputSenha.text.toString()

            // Validação visual nos campos
            if (emailDigitado.isEmpty()) {
                inputEmail.error = "Preencha o e-mail"
                return@setOnClickListener
            }

            if (senhaDigitada.isEmpty()) {
                inputSenha.error = "Preencha a senha"
                return@setOnClickListener
            }

            // --- LÓGICA DE AUTENTICAÇÃO DIRETA ---

            // 1. Rota do Usuário Comum
            if (emailDigitado == "teste@unifor.br" && senhaDigitada == "123") {
                Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeUsuarioActivity::class.java)
                startActivity(intent)
                finish() // Impede de voltar pra tela de login apertando o botão "Voltar"
            }
            // 2. Rota do Administrador
            else if (emailDigitado == "narak@unifor.br" && senhaDigitada == "123") {
                Toast.makeText(this, "Bem-vindo, Admin! (Tela em construção)", Toast.LENGTH_SHORT).show()

                // DEIXANDO PRONTO PARA O FUTURO:
                // val intent = Intent(this, HomeAdminActivity::class.java)
                // startActivity(intent)
                // finish()
            }
            // 3. Credenciais Incorretas
            else {
                Toast.makeText(this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}