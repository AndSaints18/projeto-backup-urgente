package com.example.localreview // Mantenha o seu pacote

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAnalysisActivity : AppCompatActivity() {

    // Controle do acordeão
    private var isAvaliacaoDetalhadaAberta = false

    // Nossa lista oficial de locais cadastrados
    private val locaisCadastrados = arrayOf(
        "Ama Brownie",
        "Lanchonete da UNIFOR",
        "Boteco Central",
        "Pizzaria Vignoli",
        "Café das Artes",
        "Fondue Guaramiranga"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_analysis)

        // Elementos de entrada (Nota: Mudei para AutoCompleteTextView!)
        val inputNomeLocal = findViewById<AutoCompleteTextView>(R.id.input_nome_local)
        val btnSugerirLocal = findViewById<TextView>(R.id.btn_sugerir_local) // Botão novo
        val inputObservacoes = findViewById<EditText>(R.id.input_observacoes)
        val btnAddFotos = findViewById<Button>(R.id.btn_add_fotos)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar_analise)

        // Elementos do Acordeão
        val btnToggleAvaliacoes = findViewById<TextView>(R.id.btn_toggle_avaliacoes)
        val layoutAvaliacoesDetalhadas = findViewById<LinearLayout>(R.id.layout_avaliacoes_detalhadas)

        // Botões do Menu
        val btnInicio = findViewById<Button>(R.id.btn_menu_inicio)
        val btnAdd = findViewById<Button>(R.id.btn_menu_add)
        val btnAnalises = findViewById<Button>(R.id.btn_menu_analises)

        // --- LÓGICA DO AUTOCOMPLETE ---
        // Aqui a gente "ensina" o campo de texto a usar a nossa lista de locais
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, locaisCadastrados)
        inputNomeLocal.setAdapter(adapter)

        // --- LÓGICA DO BOTÃO SUGERIR ---
        btnSugerirLocal.setOnClickListener {
            val intent = Intent(this, SugerirLocalActivity::class.java)
            startActivity(intent)
        }

        // --- LÓGICA DO ACORDEÃO ---
        btnToggleAvaliacoes.setOnClickListener {
            isAvaliacaoDetalhadaAberta = !isAvaliacaoDetalhadaAberta

            if (isAvaliacaoDetalhadaAberta) {
                layoutAvaliacoesDetalhadas.visibility = View.VISIBLE
                btnToggleAvaliacoes.text = "▲ Ocultar itens específicos"
            } else {
                layoutAvaliacoesDetalhadas.visibility = View.GONE
                btnToggleAvaliacoes.text = "▼ Avaliar itens específicos (Opcional)"
            }
        }

        // --- LÓGICA DO FORMULÁRIO ---
        btnAddFotos.setOnClickListener {
            Toast.makeText(this, "Em breve: Acesso à galeria!", Toast.LENGTH_SHORT).show()
        }

        btnSalvar.setOnClickListener {
            val nomeLocal = inputNomeLocal.text.toString().trim()

            if (nomeLocal.isEmpty()) {
                inputNomeLocal.error = "Digite o nome do local"
                return@setOnClickListener
            }

            // A VALIDAÇÃO: Bloqueia se o usuário digitar algo que não está na lista!
            if (!locaisCadastrados.contains(nomeLocal)) {
                inputNomeLocal.error = "Por favor, selecione um local válido da lista ou sugira um novo."
                return@setOnClickListener
            }

            // Se passou na validação, salva e vai pra aba "Minhas Análises"
            Toast.makeText(this, "Análise salva com sucesso!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MinhasAnalisesActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // --- LÓGICA DO MENU INFERIOR ---
        btnInicio.setOnClickListener {
            val intent = Intent(this, HomeUsuarioActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        btnAdd.setOnClickListener {
            // Já estamos na tela correta!
        }

        btnAnalises.setOnClickListener {
            val intent = Intent(this, MinhasAnalisesActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}