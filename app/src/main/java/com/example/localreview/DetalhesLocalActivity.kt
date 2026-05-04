package com.example.localreview // Mantenha seu pacote

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalhesLocalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_local)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        // Mapeando os textos que vão mudar na tela
        val txtNomeLocal = findViewById<TextView>(R.id.txt_nome_local)
        val txtCategoria = findViewById<TextView>(R.id.txt_categoria)
        val txtNotaGeral = findViewById<TextView>(R.id.txt_nota_geral)
        val txtDescricao = findViewById<TextView>(R.id.txt_descricao)

        btnVoltar.setOnClickListener {
            finish()
        }

        // 1. Recebe a etiqueta que a Home enviou
        val nomeRecebido = intent.getStringExtra("NOME_LOCAL")

        // 2. Muda o título principal na hora
        if (nomeRecebido != null) {
            txtNomeLocal.text = nomeRecebido
        }

        // 3. A Gambiarra: Muda o resto dos dados dependendo do título!
        when (nomeRecebido) {
            "Bar do Zé" -> {
                txtCategoria.text = "Categoria: Buteco / Espetinho"
                txtNotaGeral.text = "⭐ 4.8 (Baseado em 12 análises)"
                txtDescricao.text = "Um dos butecos mais tradicionais. Famoso pelo espetinho de carne de sol com queijo coalho."
            }
            "Espetinho do João" -> {
                txtCategoria.text = "Categoria: Comida de Rua"
                txtNotaGeral.text = "⭐ 4.5 (Baseado em 8 análises)"
                txtDescricao.text = "Melhor espetinho de frango com bacon da região. O molho de alho é sensacional!"
            }
            "Boteco Central" -> {
                txtCategoria.text = "Categoria: Bar / Petiscos"
                txtNotaGeral.text = "⭐ 4.2 (Baseado em 25 análises)"
                txtDescricao.text = "Ótimo ambiente com música ao vivo nos finais de semana. A porção de batata frita é muito bem servida."
            }
        }
    }
}