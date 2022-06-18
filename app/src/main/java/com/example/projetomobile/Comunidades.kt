package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomobile.databinding.ActivityComunidadesBinding
import com.example.projetomobile.databinding.FragmentFragmentoPostBinding
//import com.example.projetomobile.databinding.FragmentPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import models.PostDC

class Comunidades : AppCompatActivity() {

    lateinit var binding: ActivityComunidadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityComunidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val community = intent.getStringExtra("community")
        binding.textView2.text = community
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
    private fun tratarPost(dataSnapshot: DataSnapshot) {
        val itemList = arrayListOf<PostDC>()

        //Percorre os nós filhos da foto para transformá-los
        //em uma lista de produtos
        dataSnapshot.children.forEach {
            val post = it.getValue(PostDC::class.java)
            post?.let {
                itemList.add(it);
            }
        }
        //Chamar o método que lerá array itemList e atualizará a tela
        atualizarTela(itemList)
    }

//    Função que atualiza a tela com a lista de produtos
    fun atualizarTela(list: List<PostDC>) {
        //Limpa a tela
        binding.container.removeAllViews()

        //Percorre os itens da lista
        list.forEach {

            val fragmentBinding = FragmentFragmentoPostBinding.inflate(layoutInflater)

            //Configura os itens do layout de acordo com o produto
            fragmentBinding.imgComment.text = it.postContent
            fragmentBinding.likesId.text = it.like.toString()
            //Armazena o id para uso nas ações de marcação e exclusão
            val id = it.id as String;
            binding.container.addView(fragmentBinding.root)

        }
    }

//


}