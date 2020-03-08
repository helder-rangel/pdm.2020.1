package com.example.a10vezes

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent as Intent1

class MainActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var imageViewFoto: ImageView



    private lateinit var  btHtml : Button
    private lateinit var  btDiscar : Button
    private lateinit var  btLigar : Button
    private lateinit var  btCompartilhar : Button
    private lateinit var  btEmail : Button
    private lateinit var  btPonto : Button
    private lateinit var  btRota : Button
    private lateinit var  btSms : Button
    private lateinit var  btYouTube : Button
    private lateinit var  btFoto : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHtml)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btCompartilhar = findViewById(R.id.btCompartilhar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btSms = findViewById(R.id.btSms)
        this.btYouTube = findViewById(R.id.btYouTube)
        this.btFoto = findViewById(R.id.btFoto)

        this.btHtml.setOnClickListener({ html() })
        this.btDiscar.setOnClickListener({ discar() })
        this.btLigar.setOnClickListener { ligar() }
        this.btCompartilhar.setOnClickListener({ compartilhar() })
        this.btEmail.setOnClickListener({ email() })
        this.btPonto.setOnClickListener({ ponto() })
        this.btRota.setOnClickListener({ rota() })
        this.btSms.setOnClickListener({ sms() })
        this.btYouTube.setOnClickListener({ youtube() })
        this.btFoto.setOnClickListener({ foto() })
    }

    fun html(){
        val uri = Uri.parse("http://www.ifpb.edu.br")
        val intent = Intent1(Intent1.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun discar(){
        val uri = Uri.parse("tel:36121392")
        val intent = Intent1(Intent1.ACTION_DIAL, uri)

        startActivity(intent)
    }

    fun ligar(){
        val uri = Uri.parse("tel:36121392")
        val intent = Intent1(Intent1.ACTION_CALL, uri)

        val call = Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED

        if (ContextCompat.checkSelfPermission(this, call) == granted){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Ligação Indisponível", Toast.LENGTH_SHORT).show()
        }

    }

    fun compartilhar(){
        val intent = Intent1(Intent1.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent1.EXTRA_TEXT, "Texto para compartilhar")

        // intent.setPackage("com.whatsapp")

        if (intent.resolveActivity(packageManager) != null){
            startActivity(Intent1.createChooser(intent, "Compartilhar"))
        }else{
            Toast.makeText(this, "Compartilhamento Indisponível", Toast.LENGTH_SHORT).show()
        }
    }

    fun email(){
        val uri = Uri.parse("mailto:<endereço do e-mail>")
        val intent = Intent1(Intent1.ACTION_SENDTO, uri)
        intent.putExtra(Intent1.EXTRA_SUBJECT, "Assunto")
        intent.putExtra(Intent1.EXTRA_TEXT, "Texto")

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "E-mail Indisponível", Toast.LENGTH_SHORT).show()
        }
    }

    fun ponto(){
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")
        val intent = Intent1(Intent1.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Visualização do Ponto Indisponível", Toast.LENGTH_SHORT).show()
        }
    }

    fun rota(){
        val origem = "-7.1356496,-34.8760932"
        val destino = "-7.1181836,-34.8730402"
        val url = "http://maps.google.com/maps"
        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")

        val intent = Intent1(Intent1.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Visualização da Rota Indisponível", Toast.LENGTH_SHORT).show()
        }
    }

    fun sms(){
        val uri = Uri.parse("sms:36121392")
        val intent = Intent1(Intent1.ACTION_SENDTO, uri)

        intent.putExtra("sms_body", "Mensagem")

        startActivity(intent)
    }

    fun youtube(){
        val uri = Uri.parse("vnd.youtube://dglqGGyWbVo")
        val intent = Intent1(Intent1.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Youtube Indisponível", Toast.LENGTH_SHORT).show()
        }
    }

    fun foto(){
        val intent = Intent1(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: android.content.Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FOTO && resultCode == RESULT_OK) {
            val foto = data?.extras?.get("data") as Bitmap
            imageViewFoto.setImageBitmap(imageBitmap)
            val janela = AlertDialog.Builder(ths)
            janela.setTitle("Minha foto")
            janela.setIcon(R.mipmap.ic_launcher)
            janela.setPositiveButton("ok",null)
            imageViewFoto.setImageBitmap(foto)
            janela.setView(imageViewFoto)
            janela.create().show()
        }
        super.onActivityResult(requestCode, resultCode,data)
    }
}

