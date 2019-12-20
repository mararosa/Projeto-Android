package br.com.android.projetoimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //abrindo o shared prefeences
        val dadosLogin = getSharedPreferences("dados-login", Context.MODE_PRIVATE)

        //obtendo as informaçoes do shared preference
        val email = dadosLogin.getString("email", "Não Encontrado")
        val senha_login= dadosLogin.getString("senha_cadastro", "Não Encontrado")

        //Listener (ouvinte) para o bbotao entrar
        btnEntrar.setOnClickListener {
            //Obtendo informação do EditText
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtSenha.text.toString()
                .trim() // trim copila todos os espaços, tira todos os espaços do campo

            //txvResultado.text = "Bem-vindo $usuario"

            if (usuario.isNotEmpty()) {
                if (senha.isNotEmpty()) {
                    if (usuario == email && senha == senha_login) {
                        // txvResultado.text = "Logado" Agora ao inves de aparecer logado vamos para a tela main
                        //Alertando que o cadastro foi efetuado
                        AlertDialog.Builder(this@LoginActivity)
                            .setTitle("Sucesso") //Titulo
                            .setMessage("Login Efetuado")
                            .setPositiveButton("OK") { _, _ ->
                                //Indo para a próxima tela
                                val intentLoginResultado =
                                    Intent(this@LoginActivity, ResultadoActivity::class.java)
                                startActivity(intentLoginResultado)
                            }
                            .setCancelable(false)//Ele bloqueia que o usuario feche o alerta clicando fora do alerta
                            .create()
                            .show()
                    } else {
                        //txvResultado.text = "Usuário ou Senha incorretos"
                        Toast.makeText(
                            this@LoginActivity,
                            "Usuário ou Senha incorretos!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    //txvResultado.text = "Senha vazia"
                    Toast.makeText(
                        this@LoginActivity,
                        "Preencha todos os campos!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                //txvResultado.text = "Usuário vazio"
                Toast.makeText(this@LoginActivity, "Preencha todos os campos!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        //Listener (ouvinte) para o botao cadastrar
        btnCadastrar.setOnClickListener {
            //Abrindo a tela de cadastro
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }

    }
}
