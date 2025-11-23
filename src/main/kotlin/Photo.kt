class Photo(
    val photo: PhotoAttachment,
    override val type: String = "photo",
) : Attachment