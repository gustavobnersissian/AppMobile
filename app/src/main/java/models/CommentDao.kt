package models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CommentDao {
    @Insert
    fun insert(note: Comment)

    @Query(value = "SELECT * FROM Comment")
    fun list(): List<Comment>

}