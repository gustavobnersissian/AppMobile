package models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Comment::class), version = 1)
internal abstract class AppMobile : RoomDatabase() {
    abstract fun commentDao(): CommentDao
}