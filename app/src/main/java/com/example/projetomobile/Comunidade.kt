package com.example.projetomobile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.projetomobile.databinding.ActivityComentBinding
import com.example.projetomobile.databinding.ActivityComunidadeBinding
import models.AppMobile
import models.Comment

class Comunidade : AppCompatActivity() {
    lateinit var binding: ActivityComunidadeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComunidadeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener {
            val i = Intent(this, NewPost::class.java)
            startActivityForResult(i, 1)
        }
    }



}