package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidade1Binding
import com.example.projetomobile.databinding.ActivityComunidade3Binding
import com.example.projetomobile.databinding.ActivityHomeBinding

class Comunidade3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityComunidade3Binding

        super.onCreate(savedInstanceState)

        binding = ActivityComunidade3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriarPost3.setOnClickListener {
            val x = Intent(this, CriarPost::class.java)
            startActivityForResult(x, 1)
        }

    }
}