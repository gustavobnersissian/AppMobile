package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityHomeBinding


class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtC1.setOnClickListener {
            val x = Intent(this, Comunidade1::class.java)
            startActivity(x)
        }
        binding.txtC2.setOnClickListener {
            val x = Intent(this, Comunidade2::class.java)
            startActivity(x)
        }
        binding.txtC3.setOnClickListener {
            val x = Intent(this, Comunidade3::class.java)
            startActivity(x)
        }

    }
}