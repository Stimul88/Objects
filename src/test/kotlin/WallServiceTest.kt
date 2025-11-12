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
        val post = WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments()))
        val ( id ) = post
        val result = id > 0

        assertEquals(true, result)

    }

    @Test
    fun updateFalse() {
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments()))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy", comments = Comments()))

        val result = WallService.update(Post(id = 3, text ="Hello!", friendsOnly = true, postType = "reply", comments = Comments()))

        assertEquals(false, result)
    }

    @Test
    fun updateTrue() {
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post", comments = Comments()))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy", comments = Comments()))

        val result = WallService.update(Post(id = 2, text ="Hello!", friendsOnly = true, postType = "reply", comments = Comments()))

        assertEquals(true, result)
    }
}