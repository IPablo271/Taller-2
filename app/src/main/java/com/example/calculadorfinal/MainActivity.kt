package com.example.calculadorfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var txtRultado:TextView
    lateinit var txtExppresion:TextView
    lateinit var txtCe:TextView
    lateinit var txtAbierto:TextView
    lateinit var txtCerrado:TextView
    lateinit var txtDivision:TextView
    lateinit var txtSiete:TextView
    lateinit var txtOcho:TextView
    lateinit var txtNueve:TextView
    lateinit var txtMultiplicacion:TextView
    lateinit var txtCuatro:TextView
    lateinit var txtCinco:TextView
    lateinit var txtSeis:TextView
    lateinit var txtSuma:TextView
    lateinit var txtUno:TextView
    lateinit var txtDos:TextView
    lateinit var txtTres:TextView
    lateinit var txtResta:TextView
    lateinit var txtPunto:TextView
    lateinit var txtCero:TextView
    lateinit var txtBack:TextView
    lateinit var txtIgual:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        txtRultado=findViewById(R.id.txtResult)
        txtExppresion=findViewById(R.id.txtExpression)
        txtCe=findViewById(R.id.txtCe)
        txtCerrado=findViewById(R.id.txtCerrado)
        txtAbierto=findViewById(R.id.txtAbierto)
        txtDivision=findViewById(R.id.txtdivision)
        txtSiete=findViewById(R.id.txtsiete)
        txtOcho=findViewById(R.id.txtocho)
        txtNueve=findViewById(R.id.txtnueve)
        txtMultiplicacion=findViewById(R.id.txtmultiplicacion)
        txtCuatro=findViewById(R.id.txtcuatro)
        txtCinco=findViewById(R.id.txtcinco)
        txtSeis=findViewById(R.id.txtseis)
        txtSuma=findViewById(R.id.txtsuma)
        txtUno=findViewById(R.id.txtuno)
        txtDos=findViewById(R.id.txtdos)
        txtTres=findViewById(R.id.txttres)
        txtResta=findViewById(R.id.txtresta)
        txtPunto=findViewById(R.id.txtdot)
        txtCero=findViewById(R.id.txtcero)
        txtBack=findViewById(R.id.txtback)
        txtIgual=findViewById(R.id.txtigual)

        //Set de los numeros
        txtUno.setOnClickListener {appendOnExpression("1",true)  }
        txtDos.setOnClickListener {appendOnExpression("2",true)  }
        txtTres.setOnClickListener {appendOnExpression("3",true)  }
        txtCuatro.setOnClickListener {appendOnExpression("4",true)  }
        txtCinco.setOnClickListener {appendOnExpression("5",true)  }
        txtSeis.setOnClickListener {appendOnExpression("6",true)  }
        txtSiete.setOnClickListener {appendOnExpression("7",true)  }
        txtOcho.setOnClickListener {appendOnExpression("8",true)  }
        txtNueve.setOnClickListener {appendOnExpression("9",true)  }
        txtCero.setOnClickListener {appendOnExpression("0",true)  }
        txtPunto.setOnClickListener {appendOnExpression(".",true)  }

        //Operaciones
        txtSuma.setOnClickListener {appendOnExpression("+",false)  }
        txtResta.setOnClickListener {appendOnExpression("-",false)  }
        txtMultiplicacion.setOnClickListener {appendOnExpression("*",false)  }
        txtDivision.setOnClickListener {appendOnExpression("/",false)  }
        txtAbierto.setOnClickListener {appendOnExpression("(",false)  }
        txtCerrado.setOnClickListener {appendOnExpression(")",false)  }


        txtCe.setOnClickListener {
            txtExppresion.text = ""
            txtRultado.text=""
        }
        txtBack.setOnClickListener {
            val string=txtExppresion.text.toString()
            if(string.isNotEmpty()){
                txtExppresion.text=string.substring(0,string.length-1)
            }
            txtRultado.text=""
        }
        txtIgual.setOnClickListener {
            try{
                val expression=ExpressionBuilder(txtExppresion.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble())
                    txtRultado.text=longResult.toString()
                else
                    txtRultado.text=result.toString()
            }catch (e:Exception){
                Log.d("Exception","mesanje : "+e.message)
            }
        }
    }
    fun appendOnExpression(string:String,canClear:Boolean){
        if(txtRultado.text.isNotEmpty()){
            txtExppresion.text=""
        }
        if(canClear){
            txtRultado.text=""
            txtExppresion.append(string)
        }else{
            txtExppresion.append(txtRultado.text)
            txtExppresion.append(string)
            txtRultado.text=""
        }

    }






}