package com.example.projetomobile

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.text.TextUtils
import android.util.Patterns
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.example.projetomobile.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    // Binding
    private lateinit var binding:ActivityLoginBinding

    // Barra de ação
    private lateinit var actionBar: ActionBar

    // Dialog
    private lateinit var progressDialog: ProgressDialog

    // Firebase
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Barra de ação
        actionBar = supportActionBar!!
        actionBar.title = "Login"

        // Dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Por favor espere...")
        progressDialog.setMessage("Logando...")
        progressDialog.setCanceledOnTouchOutside(false)

        // Iniciar Firebase Authentication
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        // SignUP
        binding.noAccountTv.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        // Login
        binding.LoginBtn.setOnClickListener {
            // Antes de logar, validar a data
            validateData()
        }


    }

    private fun getUsername() {
        var nomeUsuario = email
        nomeUsuario.substringBeforeLast("@")
        print(nomeUsuario)
    }

    private fun validateData() {
        // Pega data
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        // Validar
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Forma Inválida de E-mail
            binding.emailEt.error = "Formato de e-mail inválido!"
        }
        else if (TextUtils.isEmpty(password)) {
            // Sem senha
            binding.passwordEt.error = "Por favor, insira uma senha"
        }
        else {
            // Válido
            // Logar
            firebaseAuthLogin()
        }

    }

    private fun firebaseAuthLogin() {

        // Mostra progresso
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                // Sucesso no login
                progressDialog.dismiss()
                // Pega info do usuário
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Logou como $email", Toast.LENGTH_SHORT).show()

                //getUsername()

                // Abre profile activity
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                // Falha no login
                progressDialog.dismiss()
                //.makeText(this, "Login falhou, ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        // Se estiver logado -> vai para profile activity
        // pega usuário atual
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            // Está logado!
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

    }
}