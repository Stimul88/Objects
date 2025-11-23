data class Thread(
    val count : Int, // количество комментариев в ветке
    val items : Array<Int>? = emptyArray(), // массив объектов комментариев к записи
    val canPost : Boolean, // может ли текущий пользователь оставлять комментарии в этой ветке
    val showReplyButton : Boolean, // нужно ли отображать кнопку «ответить» в ветке
    val groupsCanPost : Boolean // могут ли сообщества оставлять комментарии в ветке
)