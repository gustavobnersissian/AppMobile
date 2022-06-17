package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidade1Binding

class Comunidade1 : AppCompatActivity() {

    lateinit var binding: ActivityComunidade1Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityComunidade1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriarPost1.setOnClickListener {
            val x = Intent(this, CriarPost::class.java)
            startActivityForResult(x, 1)
        }
    }
}