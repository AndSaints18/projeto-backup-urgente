package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_usuario)

        val btnInicio = findViewById<Button>(R.id.btn_menu_inicio)
        val btnAdd = findViewById<Button>(R.id.btn_menu_add)
        val btnAnalises = findViewById<Button>(R.id.btn_menu_analises)

        val cardBarDoZe = findViewById<LinearLayout>(R.id.card_bar_do_ze)
        val cardEspetinho = findViewById<LinearLayout>(R.id.card_espetinho_joao);
        val cardBoteco = findViewById<LinearLayout>(R.id.card_boteco_central);

        cardBarDoZe.setOnClickListener {
            val intent = Intent(this, DetalhesLocalActivity::class.java)
            intent.putExtra("NOME_LOCAL", "Bar do Zé") // A Etiqueta!
            startActivity(intent)
        }

        cardEspetinho.setOnClickListener {
            val intent = Intent(this, DetalhesLocalActivity::class.java)
            intent.putExtra("NOME_LOCAL", "Espetinho do João") // A Etiqueta!
            startActivity(intent)
        }

        cardBoteco.setOnClickListener {
            val intent = Intent(this, DetalhesLocalActivity::class.java)
            intent.putExtra("NOME_LOCAL", "Boteco Central") // A Etiqueta!
            startActivity(intent)
        }

        btnInicio.setOnClickListener {
            Toast.makeText(this, "Você já está na tela de Início!", Toast.LENGTH_SHORT).show()
        }

        btnAdd.setOnClickListener {
            val intent = Intent(this, CreateAnalysisActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        btnAnalises.setOnClickListener {
            val intent = Intent(this, MinhasAnalisesActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}