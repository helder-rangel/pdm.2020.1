package com.example.ex_pobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvNumeros: TextView
    private lateinit var btMegaSena: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvNumeros = findViewById(R.id.tvNumeros)
        this.btMegaSena = findViewById((R.id.btMegaSenaOn))

        this.btMegaSena.setOnClickListener(OnClickButton())

        //this.tvNumeros.text = Megasena.getInstance().toSortedSet().toString()
    }

    inner class OnClickButton : View.OnClickListener {
        override fun onClick(v: View?){
            this@MainActivity.tvNumeros.text = Megasena.getInstance().joinToString ( " " )
        }
    }
}