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
        val post = WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post"))
        val ( id ) = post
        val result = id > 0

        assertEquals(true, result)

    }

    @Test
    fun update() {
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "post"))
        WallService.add(Post(text ="Hello!", friendsOnly = true, postType = "copy"))

        val result = WallService.update(Post(id = 3, text ="Hello!", friendsOnly = true, postType = "reply"))

        assertEquals(false, result)
    }
}