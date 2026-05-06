package com.example.localreview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LocaisFavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_favoritos)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_favoritos)

        val cardBrownie = findViewById<CardView>(R.id.card_fav_brownie)
        val cardCafe = findViewById<CardView>(R.id.card_fav_cafe)
        val cardPizzaria = findViewById<CardView>(R.id.card_fav_pizzaria)

        val btnRemoverBrownie = findViewById<TextView>(R.id.btn_remover_fav_brownie)
        val btnRemoverCafe = findViewById<TextView>(R.id.btn_remover_fav_cafe)
        val btnRemoverPizzaria = findViewById<TextView>(R.id.btn_remover_fav_pizzaria)

        btnVoltar.setOnClickListener { finish() }

        // Navegação para Detalhes do Local
        cardBrownie.setOnClickListener { abrirDetalhes("Ama Brownie") }
        cardCafe.setOnClickListener { abrirDetalhes("Café das Artes") }
        cardPizzaria.setOnClickListener { abrirDetalhes("Pizzaria Vignoli") }

        // Lógica para desfavoritar
        btnRemoverBrownie.setOnClickListener { confirmarRemocao("Ama Brownie", cardBrownie) }
        btnRemoverCafe.setOnClickListener { confirmarRemocao("Café das Artes", cardCafe) }
        btnRemoverPizzaria.setOnClickListener { confirmarRemocao("Pizzaria Vignoli", cardPizzaria) }
    }

    private fun abrirDetalhes(nome: String) {
        val intent = Intent(this, DetalhesLocalActivity::class.java)
        intent.putExtra("NOME_LOCAL", nome)
        startActivity(intent)
    }

    private fun confirmarRemocao(nome: String, card: CardView) {
        AlertDialog.Builder(this)
            .setTitle("Remover Favorito")
            .setMessage("Deseja remover $nome da sua lista de favoritos?")
            .setPositiveButton("Remover") { dialog, _ ->
                card.visibility = View.GONE
                Toast.makeText(this, "$nome removido dos favoritos", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}