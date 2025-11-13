import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Before
    fun setUp() {
        WallService.clear()
    }

    @Test
    fun add() {
        val photo: Attachment = Photo(photo = PhotoAttachment(1, 1, "https://vk.com/some_photo_link", "https://vk.com/some_photo_link"))
        val video: Attachment = Video(video = VideoAttachment(1, 1, "A Funny Video", 30))
        val post = WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments(), attachment = photo))
        val ( id ) = post
        val result = id > 0

        assertEquals(true, result)

    }

    @Test
    fun updateFalse() {
        val photo: Attachment = Photo(photo = PhotoAttachment(1, 1, "https://vk.com/some_photo_link", "https://vk.com/some_photo_link"))
        val video: Attachment = Video(video = VideoAttachment(1, 1, "A Funny Video", 30))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments(), attachment = photo))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy", comments = Comments(), attachment = video))

        val result = WallService.update(Post(id = 3, text ="Hello!", friendsOnly = true, postType = "reply", comments = Comments(), attachment = video))

        assertEquals(false, result)
    }

    @Test
    fun updateTrue() {
        val photo: Attachment = Photo(photo = PhotoAttachment(1, 1, "https://vk.com/some_photo_link", "https://vk.com/some_photo_link"))
        val video: Attachment = Video(video = VideoAttachment(1, 1, "A Funny Video", 30))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments(), attachment = photo))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy", comments = Comments(), attachment = video))

        val result = WallService.update(Post(id = 2, text ="Hello!", friendsOnly = true, postType = "reply", comments = Comments(), attachment = video))

        assertEquals(true, result)
    }
}