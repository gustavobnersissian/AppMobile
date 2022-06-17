package com.example.projetomobile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidade1Binding
import com.example.projetomobile.databinding.ActivityCriarPostBinding

class CriarPost : AppCompatActivity() {

    lateinit var binding: ActivityCriarPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCriarPostBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPostar.setOnClickListener {
            // Ao clicar no botão de postar, volta para a ultima atividade automaticamente
            val returnIntent = Intent()
            returnIntent.putExtra("retorno", "Dados de Retorno")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }









}