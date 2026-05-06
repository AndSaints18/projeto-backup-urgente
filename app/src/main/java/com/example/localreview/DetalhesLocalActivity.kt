package com.example.localreview

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalhesLocalActivity : AppCompatActivity() {

    // Variável para guardar se o local está favoritado ou não
    private var isFavorito = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_local)

        try {
            val btnVoltar = findViewById<Button>(R.id.btn_voltar)

            // Textos
            val txtNomeLocal = findViewById<TextView>(R.id.txt_nome_local)
            val txtCategoria = findViewById<TextView>(R.id.txt_categoria)
            val txtNotaGeral = findViewById<TextView>(R.id.txt_nota_geral)
            val txtDescricao = findViewById<TextView>(R.id.txt_descricao)

            // Botões Novos e Antigos
            val btnFavoritar = findViewById<Button>(R.id.btn_acao_favoritar)
            val btnMapa = findViewById<Button>(R.id.btn_acao_mapa)
            val btnCriarAvaliacao = findViewById<Button>(R.id.btn_criar_avaliacao) // O Botão Mágico!

            btnVoltar.setOnClickListener {
                finish()
            }

            // 1. Recebe a etiqueta que a Home enviou
            val nomeRecebido = intent.getStringExtra("NOME_LOCAL") ?: "Local Desconhecido"

            // 2. Muda o título
            txtNomeLocal.text = nomeRecebido

            // --- LÓGICA DO BOTÃO AVALIAR ESTE LOCAL ---
            btnCriarAvaliacao.setOnClickListener {
                val intent = Intent(this, CreateAnalysisActivity::class.java)
                // Enviamos o nome do local atual caso queira auto-preencher lá na frente!
                intent.putExtra("LOCAL_PREENCHER", nomeRecebido)
                startActivity(intent)
            }

            // --- LÓGICA DO BOTÃO FAVORITAR (Toggle) ---
            btnFavoritar.setOnClickListener {
                isFavorito = !isFavorito // Inverte o estado atual

                if (isFavorito) {
                    // Pinta o botão de vermelho claro e muda o texto
                    btnFavoritar.text = "❤️ Salvo"
                    btnFavoritar.setBackgroundColor(Color.parseColor("#FFEBEE"))
                    btnFavoritar.setTextColor(Color.parseColor("#D32F2F"))
                    Toast.makeText(this, "Adicionado aos favoritos!", Toast.LENGTH_SHORT).show()
                } else {
                    // Volta o botão pro cinza normal
                    btnFavoritar.text = "🤍 Favoritar"
                    btnFavoritar.setBackgroundColor(Color.parseColor("#F1F3F5"))
                    btnFavoritar.setTextColor(Color.parseColor("#495057"))
                    Toast.makeText(this, "Removido dos favoritos.", Toast.LENGTH_SHORT).show()
                }
            }

            // --- LÓGICA DO BOTÃO COMO CHEGAR (Google Maps) ---
            btnMapa.setOnClickListener {
                Toast.makeText(this, "Abrindo rotas para: $nomeRecebido", Toast.LENGTH_SHORT).show()
                try {
                    // Cria uma URL de pesquisa de endereço para o Maps usando o nome do local
                    val uri = Uri.parse("geo:0,0?q=${Uri.encode(nomeRecebido)}")
                    val mapIntent = Intent(Intent.ACTION_VIEW, uri)

                    // Diz ao Android que queremos um app de mapas
                    mapIntent.setPackage("com.google.android.apps.maps")

                    startActivity(mapIntent)
                } catch (e: Exception) {
                    // Fallback: Se o usuário não tiver o app do Maps instalado, abre no navegador!
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=${Uri.encode(nomeRecebido)}"))
                    startActivity(browserIntent)
                }
            }

            // 3. Os Dados Mockados
            when (nomeRecebido) {
                "Ama Brownie" -> {
                    txtCategoria.text = "Categoria: Doceria / Artesanal"
                    txtNotaGeral.text = "⭐ 5.0 (Baseado em 45 análises)"
                    txtDescricao.text = "A melhor doceria da cidade. Famosa por seus brownies recheados e ambiente super acolhedor para a família. Ótimo custo-benefício."
                }
                "Lanchonete da UNIFOR" -> {
                    txtCategoria.text = "Categoria: Salgados / Universitário"
                    txtNotaGeral.text = "⭐ 3.5 (Baseado em 120 análises)"
                    txtDescricao.text = "O ponto de encontro dos alunos entre as aulas. Salgados variados, sucos rápidos e muito movimento. Ideal para lanches rápidos."
                }
                "Boteco Central" -> {
                    txtCategoria.text = "Categoria: Bar / Petiscos"
                    txtNotaGeral.text = "⭐ 4.2 (Baseado em 80 análises)"
                    txtDescricao.text = "Um dos bares mais tradicionais da região. Famoso pela cerveja sempre trincando e porções bem servidas. Excelente para ir com os amigos na sexta-feira."
                }
                "Pizzaria Vignoli" -> {
                    txtCategoria.text = "Categoria: Pizzas / Massas Leves"
                    txtNotaGeral.text = "⭐ 4.6 (Baseado em 210 análises)"
                    txtDescricao.text = "Pizzas de massa muito fina e crocante feitas no forno a lenha. Ambiente familiar, aconchegante e com uma carta de vinhos excelente."
                }
                "Café das Artes" -> {
                    txtCategoria.text = "Categoria: Cafeteria / Ambiente Calmo"
                    txtNotaGeral.text = "⭐ 4.9 (Baseado em 65 análises)"
                    txtDescricao.text = "O local ideal para estudar ou trabalhar. Cafés especiais, internet rápida, tomadas disponíveis e uma decoração que inspira."
                }
                "Fondue Guaramiranga", "Fondue em Guaramiranga" -> {
                    txtCategoria.text = "Categoria: Jantar / Clima Frio"
                    txtNotaGeral.text = "⭐ 4.8 (Baseado em 95 análises)"
                    txtDescricao.text = "A melhor experiência gastronômica da serra. Fondue de queijo e chocolate com ingredientes premium e ambiente extremamente romântico."
                }
                else -> {
                    txtCategoria.text = "Categoria: Não especificada"
                    txtNotaGeral.text = "⭐ Sem avaliações"
                    txtDescricao.text = "Detalhes não encontrados para este estabelecimento."
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao carregar detalhes.", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}