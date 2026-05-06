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

        // 1. Mapeamento do Menu Inferior
        val btnInicio = findViewById<Button>(R.id.btn_menu_inicio)
        val btnAdd = findViewById<Button>(R.id.btn_menu_add)
        val btnAnalises = findViewById<Button>(R.id.btn_menu_analises)

        // 2. Mapeamento dos Itens da Lista de Perfil
        val btnTodasAvaliacoes = findViewById<LinearLayout>(R.id.btn_todas_avaliacoes)
        val btnLocaisSalvos = findViewById<LinearLayout>(R.id.btn_locais_salvos)
        val btnConfiguracoes = findViewById<LinearLayout>(R.id.btn_configuracoes)
        val btnAjudaSuporte = findViewById<LinearLayout>(R.id.btn_ajuda_suporte)
        val btnSobre = findViewById<LinearLayout>(R.id.btn_sobre)
        val btnSair = findViewById<LinearLayout>(R.id.btn_sair)

        // --- LÓGICA DA LISTA DO PERFIL ---

        btnTodasAvaliacoes.setOnClickListener {
            val intent = Intent(this, TodasAvaliacoesActivity::class.java)
            startActivity(intent)
        }

        btnLocaisSalvos.setOnClickListener {
            val intent = Intent(this, LocaisFavoritosActivity::class.java)
            startActivity(intent)
        }

        btnConfiguracoes.setOnClickListener {
            Toast.makeText(this, "Abrindo: Configurações...", Toast.LENGTH_SHORT).show()
        }

        btnAjudaSuporte.setOnClickListener {
            val intent = Intent(this, AjudaSuporteActivity::class.java)
            startActivity(intent)
        }

        btnSobre.setOnClickListener {
            val intent = Intent(this, SobreActivity::class.java)
            startActivity(intent)
        }

        // LÓGICA DE LOGOUT (Sair da Conta)
        btnSair.setOnClickListener {
            Toast.makeText(this, "Saindo da conta...", Toast.LENGTH_SHORT).show()

            // Supondo que sua tela inicial se chame LoginActivity.
            // Se tiver outro nome (ex: MainActivity), mude aqui!
            val intent = Intent(this, LoginActivity::class.java)

            // Essa flag é super importante: Ela "mata" o histórico.
            // O usuário não consegue voltar pro perfil apertando o botão "Voltar" do Android.
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // --- LÓGICA DO MENU INFERIOR ---

        btnInicio.setOnClickListener {
            val intent = Intent(this, HomeUsuarioActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            overridePendingTransition(0, 0) // Remove a animação para dar sensação de aba
            finish()
        }

        btnAdd.setOnClickListener {
            val intent = Intent(this, CreateAnalysisActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        btnAnalises.setOnClickListener {
            Toast.makeText(this, "Você já está no seu Perfil!", Toast.LENGTH_SHORT).show()
        }
    }
}