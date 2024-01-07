package com.example.jetpackcompose.domain

import com.example.jetpackcompose.R

data class VkPostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long Comment Text",
    val publicationDate: String = "14:00"
)