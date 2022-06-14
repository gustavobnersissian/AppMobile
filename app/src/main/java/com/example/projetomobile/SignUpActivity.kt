package com.example.projetomobile

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.example.projetomobile.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var actionBar: ActionBar
    private lateinit var progressDialog: ProgressDialog

    // Auth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Action Bar
        actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Por favor espere...")
        progressDialog.setMessage("Criando conta...")
        progressDialog.setCanceledOnTouchOutside(false)

        // Inicia Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        //
        binding.signUpBtn.setOnClickListener {
            // Valida dados
            validateData()
        }
    }

    private fun validateData() {
        // Pega
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        // Valida
        // Validar
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Forma Inválida de E-mail
            binding.emailEt.error = "Formato de e-mail inválido!"
        }
        else if (TextUtils.isEmpty(password)) {
            // Sem senha
            binding.passwordEt.error = "Por favor, insira uma senha"
        }
        else if (password.length < 6){
            binding.passwordEt.error = "Senha deve ter mais que 6 caracteres"
        }
        else {
            // Válido, logar
            firebaseSignUp()
        }

    }

    private fun firebaseSignUp() {
        // Progresso
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                progressDialog.dismiss()
                // Válido, logar
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Conta criada com email $email", Toast.LENGTH_SHORT).show()

                // Abre Profile
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Criar conta falhou", Toast.LENGTH_SHORT).show()
            }
    }


    override fun onSupportNavigateUp(): Boolean {
        // Volta para atividade anterior quando botão de voltar pressionado
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}