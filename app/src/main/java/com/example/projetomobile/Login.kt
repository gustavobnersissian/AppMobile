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
import com.firebase.ui.auth.AuthUI
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

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build())

        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(), 0
            )
        }
        else {
            Toast.makeText(this,"Já logado!", Toast.LENGTH_LONG).show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this,"Logado!", Toast.LENGTH_LONG).show()
            } else {
                finishAffinity()
            }
        }
    }


}




