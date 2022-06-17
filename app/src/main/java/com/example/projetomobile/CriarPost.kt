package com.example.projetomobile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidadesBinding
import com.example.projetomobile.databinding.ActivityCriarPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import models.PostDC
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class CriarPost : AppCompatActivity() {

    lateinit var binding: ActivityCriarPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCriarPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val community = intent.getStringExtra("community")

        val simpleDate = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = simpleDate.format(Date()).toString()
        val date = currentDate.split(" ").toTypedArray()[0]
        val hours = currentDate.split(" ").toTypedArray()[1]

        var database: DatabaseReference? = null

        val usuario = FirebaseAuth.getInstance().currentUser
        if (usuario != null) {
                database = FirebaseDatabase.getInstance().reference.child(usuario.uid)
            }


        // Função de criar post na comunidade
        binding.btnPostar.setOnClickListener {


            val post = PostDC(
                postContent = binding.txtConteudo.text.toString(),
                username = FirebaseAuth.getInstance().currentUser.toString(),
                community = community.toString(),
                like = 0,
                date = date,
                hours = hours,
                comments = arrayListOf()
            )

            val newPost = database?.child("post")?.push()
            post.id = newPost?.key
            newPost?.setValue(post)

            // Ao clicar no botão de postar, volta para a ultima atividade automaticamente
            val returnIntent = Intent()
            returnIntent.putExtra("retorno", "Dados de Retorno")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }









}