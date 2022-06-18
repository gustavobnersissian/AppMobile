package models

import java.util.*
import kotlin.collections.ArrayList

data class PostDC(
    var id: String? = null,
    var postContent: String,
    var username: String,
    var community:String,
    var like: Int = 0,
    var date: String,
    var hours: String,
    var comments: ArrayList<String>? = null
)

