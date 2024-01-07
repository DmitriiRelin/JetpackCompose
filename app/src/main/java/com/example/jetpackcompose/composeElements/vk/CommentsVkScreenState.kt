package com.example.jetpackcompose.composeElements.vk

import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkPostComment

sealed class CommentsVkScreenState {

    object Initial : CommentsVkScreenState()

    data class Comments(val feedPost: VkFeedPost, val comments: List<VkPostComment>) : CommentsVkScreenState()
}