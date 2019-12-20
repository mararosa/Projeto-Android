package br.com.android.projetoimc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //abrindo o shared prefeences
        val dadosLogin = getSharedPreferences("dados-login", Context.MODE_PRIVATE)

        //obtendo as informaçoes do shared preference
        val nome = dadosLogin.getString("name", "Não Encontrado")

        txtNome.text = nome

    }
}
