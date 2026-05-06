package com.example.localreview

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MinhaAnaliseDetalheActivity : AppCompatActivity() {

    private var isAcordeaoAberto = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_analise_detalhes)

        try {
            // Botão Voltar
            val btnVoltar = findViewById<Button>(R.id.btn_voltar_minhas_analises)
            btnVoltar.setOnClickListener { finish() }

            // Elementos Principais
            val txtNomeLocal = findViewById<TextView>(R.id.txt_nome_local_analisado)
            val txtMinhaNotaFinal = findViewById<TextView>(R.id.txt_minha_nota_final)
            val txtMeuComentario = findViewById<TextView>(R.id.txt_meu_comentario)

            // Elementos do Acordeão
            val btnToggleNotas = findViewById<TextView>(R.id.btn_toggle_notas)
            val layoutNotasDetalhadas = findViewById<LinearLayout>(R.id.layout_notas_detalhadas)

            // As 5 Notas
            val txtAtendimento = findViewById<TextView>(R.id.txt_nota_atendimento)
            val txtQualidade = findViewById<TextView>(R.id.txt_nota_qualidade)
            val txtAmbiente = findViewById<TextView>(R.id.txt_nota_ambiente)
            val txtInfra = findViewById<TextView>(R.id.txt_nota_infra)
            val txtCusto = findViewById<TextView>(R.id.txt_nota_custo)

            // --- LÓGICA DO ACORDEÃO ---
            btnToggleNotas.setOnClickListener {
                isAcordeaoAberto = !isAcordeaoAberto

                if (isAcordeaoAberto) {
                    layoutNotasDetalhadas.visibility = View.VISIBLE
                    btnToggleNotas.text = "▲ Ocultar notas detalhadas"
                    // Muda levemente a cor do fundo do botão pra mostrar que está ativo
                    btnToggleNotas.setBackgroundColor(android.graphics.Color.parseColor("#E3F2FD"))
                } else {
                    layoutNotasDetalhadas.visibility = View.GONE
                    btnToggleNotas.text = "▼ Ver notas detalhadas"
                    btnToggleNotas.setBackgroundColor(android.graphics.Color.parseColor("#FFFFFF"))
                }
            }

            // --- LÓGICA DOS DADOS MOCKADOS ---
            // Tenta pegar de qualquer tela que tenha chamado essa
            val nomeRecebido = intent.getStringExtra("NOME_LOCAL_ANALISADO") ?: intent.getStringExtra("NOME_LOCAL")

            if (nomeRecebido != null) {
                txtNomeLocal.text = nomeRecebido
            }

            when (nomeRecebido) {
                "Ama Brownie" -> {
                    txtMinhaNotaFinal.text = "Minha Nota: ⭐ 5.0"
                    txtMeuComentario.text = "\"Atendimento impecável e os melhores doces da cidade. Recomendo muito!\""
                    txtAtendimento.text = "Atendimento: ⭐ 5.0"
                    txtQualidade.text = "Qualidade: ⭐ 5.0"
                    txtAmbiente.text = "Ambiente: ⭐ 4.0"
                    txtInfra.text = "Infraestrutura: ⭐ 4.5"
                    txtCusto.text = "Custo-Benefício: ⭐ 4.5"
                }
                "Lanchonete da UNIFOR" -> {
                    txtMinhaNotaFinal.text = "Minha Nota: ⭐ 3.5"
                    txtMeuComentario.text = "\"Ótimo para quebrar um galho entre as aulas, mas achei o salgado um pouco caro.\""
                    txtAtendimento.text = "Atendimento: ⭐ 4.0"
                    txtQualidade.text = "Qualidade: ⭐ 3.0"
                    txtAmbiente.text = "Ambiente: ⭐ 3.0"
                    txtInfra.text = "Infraestrutura: ⭐ 3.5"
                    txtCusto.text = "Custo-Benefício: ⭐ 3.0"
                }
                "Boteco Central" -> {
                    txtMinhaNotaFinal.text = "Minha Nota: ⭐ 4.2"
                    txtMeuComentario.text = "\"Cerveja muito gelada e petiscos bem servidos. O som estava um pouco alto.\""
                    txtAtendimento.text = "Atendimento: ⭐ 4.0"
                    txtQualidade.text = "Qualidade: ⭐ 4.5"
                    txtAmbiente.text = "Ambiente: ⭐ 3.5"
                    txtInfra.text = "Infraestrutura: ⭐ 3.0"
                    txtCusto.text = "Custo-Benefício: ⭐ 4.5"
                }
                "Pizzaria Vignoli" -> {
                    txtMinhaNotaFinal.text = "Minha Nota: ⭐ 4.6"
                    txtMeuComentario.text = "\"Massa fininha e ingredientes premium. Ambiente excelente para a família.\""
                    txtAtendimento.text = "Atendimento: ⭐ 5.0"
                    txtQualidade.text = "Qualidade: ⭐ 5.0"
                    txtAmbiente.text = "Ambiente: ⭐ 4.5"
                    txtInfra.text = "Infraestrutura: ⭐ 4.5"
                    txtCusto.text = "Custo-Benefício: ⭐ 4.0"
                }
                "Café das Artes" -> {
                    txtMinhaNotaFinal.text = "Minha Nota: ⭐ 4.9"
                    txtMeuComentario.text = "\"Espaço perfeito para focar nos estudos. O croissant é maravilhoso.\""
                    txtAtendimento.text = "Atendimento: ⭐ 5.0"
                    txtQualidade.text = "Qualidade: ⭐ 5.0"
                    txtAmbiente.text = "Ambiente: ⭐ 5.0"
                    txtInfra.text = "Infraestrutura: ⭐ 4.5"
                    txtCusto.text = "Custo-Benefício: ⭐ 4.5"
                }
                "Fondue em Guaramiranga", "Fondue Guaramiranga" -> {
                    txtMinhaNotaFinal.text = "Minha Nota: ⭐ 4.8"
                    txtMeuComentario.text = "\"Clima perfeito, comida maravilhosa. Só a fila de espera que estava um pouco longa.\""
                    txtAtendimento.text = "Atendimento: ⭐ 4.5"
                    txtQualidade.text = "Qualidade: ⭐ 5.0"
                    txtAmbiente.text = "Ambiente: ⭐ 5.0"
                    txtInfra.text = "Infraestrutura: ⭐ 4.0"
                    txtCusto.text = "Custo-Benefício: ⭐ 4.5"
                }
                else -> {
                    txtMinhaNotaFinal.text = "Minha Nota: Sem avaliação"
                    txtMeuComentario.text = "\"Nenhum detalhe encontrado para esta avaliação.\""
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Aviso: Alguns dados não carregaram corretamente.", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}