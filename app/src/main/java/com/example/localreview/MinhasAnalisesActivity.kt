package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MinhasAnalisesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_analises)

        val btnInicio = findViewById<Button>(R.id.btn_menu_inicio)
        val btnAdd = findViewById<Button>(R.id.btn_menu_add)
        val btnAnalises = findViewById<Button>(R.id.btn_menu_analises)

        val cardBrownie = findViewById<LinearLayout>(R.id.card_ama_brownie)
        val cardLanchonete = findViewById<LinearLayout>(R.id.card_lanchonete)
        val cardFondue = findViewById<LinearLayout>(R.id.card_fondue)

        cardBrownie.setOnClickListener {
            val intent = Intent(this, MinhaAnaliseDetalheActivity::class.java)
            intent.putExtra("NOME_LOCAL_ANALISADO", "Ama Brownie")
            startActivity(intent)
        }

        cardLanchonete.setOnClickListener {
            val intent = Intent(this, MinhaAnaliseDetalheActivity::class.java)
            intent.putExtra("NOME_LOCAL_ANALISADO", "Lanchonete da UNIFOR")
            startActivity(intent)
        }

        cardFondue.setOnClickListener {
            val intent = Intent(this, MinhaAnaliseDetalheActivity::class.java)
            intent.putExtra("NOME_LOCAL_ANALISADO", "Fondue em Guaramiranga")
            startActivity(intent)
        }

        // Botão INÍCIO
        btnInicio.setOnClickListener {
            val intent = Intent(this, HomeUsuarioActivity::class.java)
            // Flag para limpar as telas anteriores e não bugar o botão "Voltar" do celular
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // Botão ADD
        btnAdd.setOnClickListener {
            val intent = Intent(this, CreateAnalysisActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // Já estamos nela!
        btnAnalises.setOnClickListener {
                Toast.makeText(this, "Você já está no seu Perfil!", Toast.LENGTH_SHORT).show()
        }
    }
}