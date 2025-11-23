data class Comment(
    val id : Int,
    val fromId : Int,
    val date : Int,
    val text : String,
    val donut : Donut?,
    val attachments : Array<Attachment>? = emptyArray(),
    val parentsStack : Array<Int>? = emptyArray(),
    val thread : Thread?
)