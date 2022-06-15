package com.example.projetomobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.projetomobile.databinding.ActivityComentBinding
import com.example.projetomobile.databinding.ActivityComentariosBinding
import com.example.projetomobile.databinding.ActivityNewCommentBinding
import models.AppMobile
import models.Comment

class Comentarios : AppCompatActivity() {
    lateinit var binding: ActivityComentariosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComentariosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddComent.setOnClickListener {
            val intent = Intent(this,  NewComment::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        Thread{
            list()
        }.start()

    }

    fun list(){
        val db = Room.databaseBuilder(this, AppMobile::class.java, "AppMb").build()

        val listNotes = db.commentDao().list()

        runOnUiThread{
            refreshUi(listNotes)
        }

    }

    fun refreshUi(listComments: List<Comment>){
        binding.fragComent.removeAllViews()

        listComments.forEach{
            val coments = ActivityComentBinding.inflate(layoutInflater)

            coments.txtComent.text = it.desc

            binding.fragComent.addView(coments.root)
        }
    }

}