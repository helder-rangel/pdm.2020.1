package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_outra.*

class MainActivity : AppCompatActivity() {

    private lateinit var etMensagem: EditText
    private lateinit var btOk: Button
    val OUTRA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btOk = findViewById(R.id.btMainOk)

        this.etMensagem = findViewById(R.id.etMainMensagem)
        this.btOk.setOnClickListener(OnClickBotao())
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        i("APP_VAI_VOLTA", "Main - onStart")
    }

    override fun onPause() {
        super.onPause()
        i("APP_VAI_VOLTA", "Main - onStart")
    }
    override fun onStop() {
        super.onStop()
        i("APP_VAI_VOLTA", "Main - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        i("APP_VAI_VOLTA", "Main - onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        i("APP_VAI_VOLTA", "Main - onStart")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == OUTRA)
            val msg = data?.getStringExtra("MENSAGEM_VOLTA")
            this.etMensagem.setText(msg)
        }
    }else {
        Toast.makeText(this,"Voltou pelo Dispositivo", Toast.LENGTH_SHORT).show()
    }

    }


    inner class OncliCkBotao: View.OnClickListener {
        override fun onClick(v: Vew?){
            val it = Intent(this@MainActivity, OutraActivity::class.java)
           // startActivity(it)
            startActivityForResult(it, OUTRA)
        }
    }
}
