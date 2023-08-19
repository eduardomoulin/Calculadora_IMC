package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperar um UI Component de um arquivo XML
            //ID do Componente

        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso: EditText = findViewById<EditText>(R.id.edittext_Peso)
        val edtAltura: EditText = findViewById<EditText>(R.id.edittext_Altura)
        val tvResultado: TextView = findViewById<TextView>(R.id.txtMsg)
        //Colocar ação no botão
        btnCalcular.setOnClickListener {
            //Verificação para que os campos nao possam estar vazios
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                //Recuperar a msg do usuário
                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura*altura
                //Recuperar a msg do usuário
                val peso: Float = pesoStr.toFloat()
                val result: Float = peso/alturaFinal

                //Alterar o texto do text view de acordo com o que for digitado pelo usuário
                //tvResultado.text = result.toString()

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Favor preencher todos os campos!", Toast.LENGTH_LONG).show()
            }
        }


    }
}