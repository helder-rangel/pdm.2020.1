package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class OutraActivity : AppCompatActivity() {

    private lateinit var etMensagem: EditText
    private lateinit var btOk: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        this.btOk = findViewById(R.id.btOutraOk)

        this.etMensagem = findViewById(R.id.etMainMensagem)

        this.btOk.setOnClickListener(OncliCkBotao())

        this.etMensagem.setText(intent.getStringExtra("MENSAGEM"))
    }

    override fun onStart() {
        super.onStart()
        Log.e("APP_VAI_VOLTA", "Outra - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("APP_VAI_VOLTA", "Outra - onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.e("APP_VAI_VOLTA", "Outra - onPause")

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        Log.e("APP_VAI_VOLTA", "Outra - onResume")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("APP_VAI_VOLTA", "Outra - onStart")

    }
    inner class OncliCkBotao: View.OnClickListener {
        override fun onClick(v: Vew?){
            finish()
            val it = Intent(this@MainActivity, OutraActivity::class.java)
            val msg = this@MainActivity.etMensagem.text.toString()
            it.putExtra("MENSAGEM_VOLTA",msg)
            setResult(Activity.RESULT_OK,it)
            finish()
        }
    }


}
