package br.com.android.projetoimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //abrindo o shared prefeences
        val dadosLogin = getSharedPreferences("dados-login", Context.MODE_PRIVATE)
        val dadosResultado = getSharedPreferences("dados-imc", Context.MODE_PRIVATE)

        //obtendo as informaçoes do shared preference
        val nome = dadosLogin.getString("name", "Não Encontrado")
        val peso = dadosResultado.getString("peso", "Não Encontrado")
        val altura = dadosResultado.getString("altura", "Não Encontrado")
        val resultado = dadosResultado.getString("resultado", "Não Encontrado")

        txtNome.text = nome
        txtAltura.text = altura
        txtPeso.text = peso


        btnTabela.setOnClickListener {
            val intentLoginResultado = Intent(this@ResultadoActivity, TabelaActivity::class.java)
            startActivity(intentLoginResultado)
        }

    }
}
