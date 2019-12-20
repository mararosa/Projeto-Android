package br.com.android.projetoimc
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //Configurando o Shared Preferences
        val registroLogin = getSharedPreferences("dados-login", Context.MODE_PRIVATE) //1°Nome do arquivo que vai criar, 2°Modo de como você acessa esse arquivo, no caso o privite só essa variavel acessa o arquivo, 3°
        val meuEditor = registroLogin.edit() //Variavel que vai ser utilizada para incluir coisas no Shared Preference

        btnCadastroVoltar.setOnClickListener {
            //Crianco uma intent explicita
            val intentLogin2332 = Intent(this@CadastroActivity,LoginActivity::class.java)//Dentro desse parametro, você tem que colocar de onde você está, para onde você precisa ir
            //Executando a intent
            startActivity(intentLogin2332) //Dentro do parametro deve-se colocar a intent que quer executar
        }

        btnCadastroConfirma.setOnClickListener {//Botão de cadastro

            //Variáveis utilizadas
            val name = edtCadastroNome.text.toString().trim()
            val cpf = edtCadastroCpf.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim()
            val confirma_email = edtCadastroConfirmaEmail.text.toString().trim()
            val senha_cadastro = edtCadastroSenha.text.toString()
            val confirma_senha_cadastro = edtCadastroConfirmaSenha.text.toString()

            if(name.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha_cadastro.isEmpty() || confirma_email.isEmpty() || confirma_senha_cadastro.isEmpty() || (confirma_senha_cadastro != senha_cadastro) || (confirma_email != email)){
                Toast.makeText(this@CadastroActivity, "Verificar o preenchimento", Toast.LENGTH_LONG).show()
            }
            else{//Quando tudo der certo
                //Colocando as informações dentro das chaves que ficam no meuEditor, que é  o Shared Preferences
                meuEditor.putString("name",name).apply()
                meuEditor.putString("email",email).apply()
                meuEditor.putString("cpf",cpf).apply()
                meuEditor.putString("confirma_email",confirma_email).apply()
                meuEditor.putString("senha_cadastro",senha_cadastro).apply()
                meuEditor.putString("confirma_senha_cadastro",confirma_senha_cadastro).apply()

                //Alertando que o cadastro foi efetuado
                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("Sucesso") //Titulo
                    .setMessage("Usuário Cadastrado")
                    .setPositiveButton("OK"){ _, _ ->
                        //Indo para a próxima tela
                        val intentMain230 = Intent(this@CadastroActivity, ImcActivity::class.java)
                        startActivity(intentMain230)
                    }
                    .setCancelable(false)//Ele bloqueia que o usuario feche o alerta clicando fora do alerta
                    .create()
                    .show()
            }
        }
    }
}