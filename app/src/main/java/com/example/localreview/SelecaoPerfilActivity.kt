package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SelecaoPerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_perfil)

        val btnUsuario = findViewById<Button>(R.id.btn_visao_usuario)
        val btnAdmin = findViewById<Button>(R.id.btn_visao_admin)

        // Gambiarra 1: Entrando como Usuário
        btnUsuario.setOnClickListener {
            Toast.makeText(this, "Mock: Carregando visão do Usuário...", Toast.LENGTH_SHORT).show()

            // Exemplo de como você passaria o dado mockado para a próxima tela:
            // val intent = Intent(this, HomeActivity::class.java)
            // intent.putExtra("TIPO_ACESSO", "USUARIO")
            // startActivity(intent)
        }

        // Gambiarra 2: Entrando como Admin
        btnAdmin.setOnClickListener {
            Toast.makeText(this, "Mock: Carregando visão do Administrador...", Toast.LENGTH_SHORT).show()

            // Exemplo de como você passaria o dado mockado para a próxima tela:
            // val intent = Intent(this, HomeActivity::class.java)
            // intent.putExtra("TIPO_ACESSO", "ADMIN")
            // startActivity(intent)
        }
    }
}