package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidadesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Comunidades : AppCompatActivity() {

    lateinit var binding: ActivityComunidadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityComunidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val community = intent.getStringExtra("community")

        binding.btnCriarPost1.setOnClickListener {
            val x = Intent(this, CriarPost::class.java)
            x.putExtra("community", community)
            startActivity(x)
        }

        // database: id
        // usuario: nome usuário
        var database: DatabaseReference? = null

        fun configurarFirebase() {
            val usuario = FirebaseAuth.getInstance().currentUser
            if (usuario != null) {
                database = FirebaseDatabase.getInstance().reference.child(usuario.uid)
            }
        }

    }
}