data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int  = 0,
    val createdBy: Int  = 0,
    val date: Int  = 0,
    val text: String,
    val replyOwnerId: Int  = 0,
    val replyPostId: Int  = 0,
    val friendsOnly: Boolean,
    val postType: String,
)

object Comments {
    private var count = 0
    private var canPost = true
    private var groupsCanPost = true
    private var canClose = true
    private var canOpen = true
}

object WallService {

    private var posts = emptyArray<Post>()
    private var id = 0

    fun add(post: Post): Post {
        val newPost = post.copy(id = id + 1)
        posts += newPost

        id += 1
        return posts.last()
    }

    fun show() {
        for (post in posts) {
            println(post)
        }
    }

    fun update(post: Post): Boolean  {
        val (id, _, _, _, _, _, _, _, _, postType) = post

        for ((index, element) in posts.withIndex()) {
            if (element.id == id) {
                posts[index] = post.copy(postType = postType)
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }
}


fun main() {
    WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post"))
    WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy"))

    WallService.show()

    println("__________________________")

    WallService.update(Post(id = 2, text ="Hello!", friendsOnly = true, postType = "reply"))
    WallService.show()

    println("__________________________")

}