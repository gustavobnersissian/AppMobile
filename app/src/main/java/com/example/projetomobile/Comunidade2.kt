package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidade1Binding
import com.example.projetomobile.databinding.ActivityComunidade2Binding
import com.example.projetomobile.databinding.ActivityHomeBinding

class Comunidade2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityComunidade2Binding

        super.onCreate(savedInstanceState)

        binding = ActivityComunidade2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriarPost2.setOnClickListener {
            val x = Intent(this, CriarPost::class.java)
            startActivityForResult(x, 1)
        }
    }
}