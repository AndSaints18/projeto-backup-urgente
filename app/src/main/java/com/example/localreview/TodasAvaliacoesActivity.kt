package com.example.localreview

import android.content.Intent // Faltava importar o Intent!
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class TodasAvaliacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todas_avaliacoes)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_avaliacoes)

        // Mapeando os Cards inteiros
        val cardBrownie = findViewById<CardView>(R.id.card_historico_brownie)
        val cardLanchonete = findViewById<CardView>(R.id.card_historico_lanchonete)
        val cardFondue = findViewById<CardView>(R.id.card_historico_fondue)

        // Mapeando os botões de Lixeira
        val btnApagarBrownie = findViewById<TextView>(R.id.btn_apagar_brownie)
        val btnApagarLanchonete = findViewById<TextView>(R.id.btn_apagar_lanchonete)
        val btnApagarFondue = findViewById<TextView>(R.id.btn_apagar_fondue)

        btnVoltar.setOnClickListener {
            finish() // Retorna para o Dashboard do Perfil
        }

        // --- LÓGICA DE ABRIR OS DETALHES (O que estava faltando!) ---

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

        // --- LÓGICA DE EXCLUSÃO COM CONFIRMAÇÃO ---

        btnApagarBrownie.setOnClickListener {
            mostrarDialogConfirmacao("Ama Brownie", cardBrownie)
        }

        btnApagarLanchonete.setOnClickListener {
            mostrarDialogConfirmacao("Lanchonete da UNIFOR", cardLanchonete)
        }

        btnApagarFondue.setOnClickListener {
            mostrarDialogConfirmacao("Fondue em Guaramiranga", cardFondue)
        }
    }

    // Função auxiliar que cria o Pop-up na tela
    private fun mostrarDialogConfirmacao(nomeLocal: String, cardParaEsconder: CardView) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Excluir Avaliação")
        builder.setMessage("Tem certeza que deseja apagar permanentemente sua avaliação do local '$nomeLocal'?")

        // Se clicar em "Sim"
        builder.setPositiveButton("Sim, apagar") { dialog, _ ->
            // Esconde o card da tela
            cardParaEsconder.visibility = View.GONE
            Toast.makeText(this, "Avaliação excluída com sucesso.", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        // Se clicar em "Cancelar"
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss() // Apenas fecha o pop-up sem fazer nada
        }

        // Mostra o alerta na tela
        val dialog = builder.create()
        dialog.show()
    }
}