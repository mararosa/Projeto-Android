package br.com.android.projetoimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_imc.*

class ImcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        //Configurando o Shared Preferences
        val registroImc = getSharedPreferences("dados-imc", Context.MODE_PRIVATE) //1°Nome do arquivo que vai criar, 2°Modo de como você acessa esse arquivo, no caso o privite só essa variavel acessa o arquivo, 3°
        val meuEditor1 = registroImc.edit() //Variavel que vai ser utilizada para incluir coisas no Shared Preference






                seebAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


                    override fun onProgressChanged(seekBar: SeekBar,i: Int,b: Boolean){
                        txtAltura.text = "$i"

                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {
                        Toast.makeText(applicationContext,"start tracking", Toast.LENGTH_SHORT).show()
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar) {
                        Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
                    }
                })



                seebPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


                    override fun onProgressChanged(seekBar: SeekBar,i: Int,b: Boolean){
                        txtPeso.text = "$i"

                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {
                        Toast.makeText(applicationContext,"start tracking", Toast.LENGTH_SHORT).show()
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar) {
                        Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
                    }
                })


                btnCalcular.setOnClickListener {
                    //Obtendo informação do EditText

                    val weight = seebPeso.progress.toDouble()
                    val height = seebAltura.progress.toDouble() / 100

                    //val weight = seebPeso.progress
                   // val height = seebAltura.progress / 100

                    txtAltura.text = height.toString().trim()
                    txtPeso.text = weight.toString().trim()


                    val altura = txtAltura.text.toString().trim()
                    val peso = txtPeso.text.toString().trim()

                    val resultado = (weight / (height * height)).toString().trim()



                    meuEditor1.putString("peso",peso).apply()
                    meuEditor1.putString("altura",altura).apply()
                    meuEditor1.putString("resultado",resultado).apply()

                    //Alertando que o cadastro foi efetuado
                    AlertDialog.Builder(this@ImcActivity)
                        .setTitle("Sucesso") //Titulo
                        .setMessage("Cadastro Efetuado")
                        .setPositiveButton("OK") { _, _ ->
                            //Indo para a próxima tela
                            val intentLoginResultado =
                                Intent(this@ImcActivity, ResultadoActivity::class.java)
                            startActivity(intentLoginResultado)
                        }
                        .setCancelable(false)//Ele bloqueia que o usuario feche o alerta clicando fora do alerta
                        .create()
                        .show()


                }
            }
        }

