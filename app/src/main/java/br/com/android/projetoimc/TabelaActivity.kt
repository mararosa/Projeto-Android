package br.com.android.projetoimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tabela.*

class TabelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela)

        btnSite.setOnClickListener {
            startActivity(Intent(this@TabelaActivity, WebActivity::class.java))
        }
    }
}