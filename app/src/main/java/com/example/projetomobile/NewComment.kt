package com.example.projetomobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.projetomobile.databinding.ActivityNewCommentBinding
import models.AppMobile
import models.Comment

class NewComment : AppCompatActivity() {
    lateinit var binding: ActivityNewCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComment.setOnClickListener {
            val coment = Comment(desc = binding.editComent.text.toString())

            Thread{
                save(coment)
                finish()
            }.start()
        }
    }
    fun save(note: Comment){
        val db = Room.databaseBuilder(this, AppMobile::class.java, "AppMb").build()

        db.commentDao().insert(note)
    }
}