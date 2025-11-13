data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String?,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean,
    val postType: String?,
    val comments: Comments,
    val attachment: Attachment,
)

class Comments {
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

interface Attachment {
    val type: String
}

class Photo(
    val photo: PhotoAttachment,
    override val type: String = "photo",
) : Attachment

class PhotoAttachment(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String,
)

class Video (
    val video: VideoAttachment,
    override val type: String = "video",
) : Attachment

class VideoAttachment(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int,
)



fun main() {
    val photo: Attachment = Photo(photo = PhotoAttachment(1, 1, "https://vk.com/some_photo_link", "https://vk.com/some_photo_link"))
    val video: Attachment = Video(video = VideoAttachment(1, 1, "A Funny Video", 30))

    WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments(), attachment = photo))
    WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy", comments = Comments(), attachment = video))

    WallService.show()

    println("__________________________")

    WallService.update(Post(id = 2, text ="Hello!", friendsOnly = true, postType = "reply", comments = Comments(), attachment = photo))
    WallService.show()

    println("__________________________")

}