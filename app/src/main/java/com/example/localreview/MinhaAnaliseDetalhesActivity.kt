package com.example.localreview // Mantenha seu pacote

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MinhaAnaliseDetalheActivity : AppCompatActivity() {

    // Variável para controlar se o acordeão está aberto ou fechado
    private var isAcordeaoAberto = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_analise_detalhes)

        // Botão Voltar
        val btnVoltar = findViewById<Button>(R.id.btn_voltar_minhas_analises)
        btnVoltar.setOnClickListener { finish() }

        // Elementos da Tela
        val txtNomeLocal = findViewById<TextView>(R.id.txt_nome_local_analisado)
        val txtMinhaNotaFinal = findViewById<TextView>(R.id.txt_minha_nota_final)
        val txtMeuComentario = findViewById<TextView>(R.id.txt_meu_comentario)

        // Elementos do Acordeão
        val btnToggleNotas = findViewById<TextView>(R.id.btn_toggle_notas)
        val layoutNotasDetalhadas = findViewById<LinearLayout>(R.id.layout_notas_detalhadas)

        val txtAtendimento = findViewById<TextView>(R.id.txt_nota_atendimento)
        val txtQualidade = findViewById<TextView>(R.id.txt_nota_qualidade)
        val txtAmbiente = findViewById<TextView>(R.id.txt_nota_ambiente)

        // --- LÓGICA DO ACORDEÃO ---
        btnToggleNotas.setOnClickListener {
            isAcordeaoAberto = !isAcordeaoAberto // Inverte o status

            if (isAcordeaoAberto) {
                layoutNotasDetalhadas.visibility = View.VISIBLE
                btnToggleNotas.text = "▲ Ocultar notas detalhadas"
            } else {
                layoutNotasDetalhadas.visibility = View.GONE
                btnToggleNotas.text = "▼ Ver notas detalhadas"
            }
        }

        // --- LÓGICA DOS DADOS MOCKADOS ---
        val nomeRecebido = intent.getStringExtra("NOME_LOCAL_ANALISADO")

        if (nomeRecebido != null) {
            txtNomeLocal.text = nomeRecebido
        }

        when (nomeRecebido) {
            "Ama Brownie" -> {
                txtMinhaNotaFinal.text = "Minha Nota: ⭐ 5.0"
                txtMeuComentario.text =
                    "\"Atendimento impecável e os melhores doces da cidade. Recomendo muito!\""
                txtAtendimento.text = "Atendimento: ⭐ 5.0"
                txtQualidade.text = "Qualidade: ⭐ 5.0"
                txtAmbiente.text = "Ambiente: ⭐ 4.0"
            }
            "Lanchonete da UNIFOR" -> {
                txtMinhaNotaFinal.text = "Minha Nota: ⭐ 3.5"
                txtMeuComentario.text =
                    "\"Ótimo para quebrar um galho entre as aulas, mas achei o salgado um pouco caro.\""
                txtAtendimento.text = "Atendimento: ⭐ 4.0"
                txtQualidade.text = "Qualidade: ⭐ 3.0"
                txtAmbiente.text = "Ambiente: ⭐ 3.0"
            }
            "Fondue em Guaramiranga" -> {
                txtMinhaNotaFinal.text = "Minha Nota: ⭐ 4.8"
                txtMeuComentario.text =
                    "\"Clima perfeito, comida maravilhosa. Só a fila de espera que estava um pouco longa.\""
                txtAtendimento.text = "Atendimento: ⭐ 4.5"
                txtQualidade.text = "Qualidade: ⭐ 5.0"
                txtAmbiente.text = "Ambiente: ⭐ 5.0"
            }
        }
    }
}