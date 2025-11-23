object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts){
            if (comment.id == postId) {
                comments += comment
                return comment
            }
        }
        throw PostNotFoundException("Пост не найден")
    }

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
                posts[index] = post.copy(postType = postType.toString())
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