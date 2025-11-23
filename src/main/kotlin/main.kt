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

    val comment: Comment = Comment(
        1,
        4,
        123,
        "text",
        null,
        arrayOf(photo),
        null,
        null
            )

    println(WallService.createComment(1, comment))
    println(WallService.createComment(11, comment))
}