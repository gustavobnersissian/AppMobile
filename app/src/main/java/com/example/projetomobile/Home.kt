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
            val x = Intent(this, Comunidades::class.java)
            x.putExtra("community", binding.txtC1.text.toString())
            startActivity(x)
        }
        binding.txtC2.setOnClickListener {
            val x = Intent(this, Comunidades::class.java)
            x.putExtra("community", binding.txtC2.text.toString())
            startActivity(x)
        }
        binding.txtC3.setOnClickListener {
            val x = Intent(this, Comunidades::class.java)
            x.putExtra("community", binding.txtC3.text.toString())
            startActivity(x)
        }

    }
}