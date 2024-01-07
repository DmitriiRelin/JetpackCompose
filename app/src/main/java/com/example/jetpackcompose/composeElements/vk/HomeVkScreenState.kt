package com.example.jetpackcompose.composeElements.vk

import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkPostComment

sealed class HomeVkScreenState {

    object  Initial: HomeVkScreenState()

    data class Posts(val posts: List<VkFeedPost>) : HomeVkScreenState()
    data class Comments(val feedPost: VkFeedPost, val comments: List<VkPostComment>) : HomeVkScreenState()

}