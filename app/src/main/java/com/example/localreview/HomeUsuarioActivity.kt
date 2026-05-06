package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeUsuarioActivity : AppCompatActivity() {

    private lateinit var cardAmaBrownie: CardView
    private lateinit var cardLanchonete: CardView
    private lateinit var cardBoteco: CardView
    private lateinit var cardPizzaria: CardView
    private lateinit var cardCafe: CardView
    private lateinit var cardFondue: CardView

    private lateinit var listaChips: List<CardView>
    private lateinit var listaTextos: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_usuario)

        val btnInicio = findViewById<Button>(R.id.btn_menu_inicio)
        val btnAdd = findViewById<Button>(R.id.btn_menu_add)
        val btnAnalises = findViewById<Button>(R.id.btn_menu_analises)

        cardAmaBrownie = findViewById(R.id.card_ama_brownie)
        cardLanchonete = findViewById(R.id.card_lanchonete_unifor)
        cardBoteco = findViewById(R.id.card_boteco_central)
        cardPizzaria = findViewById(R.id.card_pizzaria_vignoli)
        cardCafe = findViewById(R.id.card_cafe_artes)
        cardFondue = findViewById(R.id.card_fondue_guara)

        val chipTodos = findViewById<CardView>(R.id.chip_todos)
        val chipDoces = findViewById<CardView>(R.id.chip_doces)
        val chipLanches = findViewById<CardView>(R.id.chip_lanches)
        val chipBares = findViewById<CardView>(R.id.chip_bares)
        val chipPizzarias = findViewById<CardView>(R.id.chip_pizzarias)
        val chipCafes = findViewById<CardView>(R.id.chip_cafes)
        val chipExperiencias = findViewById<CardView>(R.id.chip_experiencias)

        val tvTodos = findViewById<TextView>(R.id.tv_chip_todos)
        val tvDoces = findViewById<TextView>(R.id.tv_chip_doces)
        val tvLanches = findViewById<TextView>(R.id.tv_chip_lanches)
        val tvBares = findViewById<TextView>(R.id.tv_chip_bares)
        val tvPizzarias = findViewById<TextView>(R.id.tv_chip_pizzarias)
        val tvCafes = findViewById<TextView>(R.id.tv_chip_cafes)
        val tvExperiencias = findViewById<TextView>(R.id.tv_chip_experiencias)

        listaChips = listOf(chipTodos, chipDoces, chipLanches, chipBares, chipPizzarias, chipCafes, chipExperiencias)
        listaTextos = listOf(tvTodos, tvDoces, tvLanches, tvBares, tvPizzarias, tvCafes, tvExperiencias)

        chipTodos.setOnClickListener { filtrarCategoria("Todos", chipTodos, tvTodos) }
        chipDoces.setOnClickListener { filtrarCategoria("Doces", chipDoces, tvDoces) }
        chipLanches.setOnClickListener { filtrarCategoria("Lanches", chipLanches, tvLanches) }
        chipBares.setOnClickListener { filtrarCategoria("Bares", chipBares, tvBares) }
        chipPizzarias.setOnClickListener { filtrarCategoria("Pizzarias", chipPizzarias, tvPizzarias) }
        chipCafes.setOnClickListener { filtrarCategoria("Cafes", chipCafes, tvCafes) }
        chipExperiencias.setOnClickListener { filtrarCategoria("Experiencias", chipExperiencias, tvExperiencias) }

        cardAmaBrownie.setOnClickListener { abrirDetalhes("Ama Brownie") }
        cardLanchonete.setOnClickListener { abrirDetalhes("Lanchonete da UNIFOR") }
        cardBoteco.setOnClickListener { abrirDetalhes("Boteco Central") }
        cardPizzaria.setOnClickListener { abrirDetalhes("Pizzaria Vignoli") }
        cardCafe.setOnClickListener { abrirDetalhes("Café das Artes") }
        cardFondue.setOnClickListener { abrirDetalhes("Fondue Guaramiranga") }

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

    private fun abrirDetalhes(nomeLocal: String) {
        try {
            // Mudamos de volta para DetalhesLocalActivity!
            val intent = Intent(this, DetalhesLocalActivity::class.java)
            intent.putExtra("NOME_LOCAL", nomeLocal)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Erro: Tela não encontrada! Verifique o AndroidManifest.xml", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun filtrarCategoria(categoria: String, chipAtivo: CardView, textoAtivo: TextView) {
        for (i in listaChips.indices) {
            listaChips[i].setCardBackgroundColor(Color.parseColor("#F1F3F5"))
            listaTextos[i].setTextColor(Color.parseColor("#495057"))
        }

        chipAtivo.setCardBackgroundColor(Color.parseColor("#212121"))
        textoAtivo.setTextColor(Color.parseColor("#FFFFFF"))

        cardAmaBrownie.visibility = if (categoria == "Todos" || categoria == "Doces") View.VISIBLE else View.GONE
        cardLanchonete.visibility = if (categoria == "Todos" || categoria == "Lanches") View.VISIBLE else View.GONE
        cardBoteco.visibility = if (categoria == "Todos" || categoria == "Bares") View.VISIBLE else View.GONE
        cardPizzaria.visibility = if (categoria == "Todos" || categoria == "Pizzarias") View.VISIBLE else View.GONE
        cardCafe.visibility = if (categoria == "Todos" || categoria == "Cafes") View.VISIBLE else View.GONE
        cardFondue.visibility = if (categoria == "Todos" || categoria == "Experiencias") View.VISIBLE else View.GONE
    }
}