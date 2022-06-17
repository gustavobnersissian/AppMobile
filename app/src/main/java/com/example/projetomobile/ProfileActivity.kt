package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.projetomobile.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    // Binding
    private lateinit var binding: ActivityProfileBinding

    // Action Bar
    private lateinit var actionBar: ActionBar

    // Firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Action Bar
        actionBar = supportActionBar!!
        actionBar.title = "Profile"

        // Inicia F Auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }
    private fun checkUser() {
        // Verifica se está logado ou não
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser != null) {
            // Logado
            val email = firebaseUser.email
            binding.emailTv.text = email
        }
        else {
            // Usuário não logado
            startActivity(Intent(this, Home::class.java))
            finish()
        }
    }
}