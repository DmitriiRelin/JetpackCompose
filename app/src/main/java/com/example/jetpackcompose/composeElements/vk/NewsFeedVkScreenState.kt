package com.example.jetpackcompose.composeElements.vk

import com.example.jetpackcompose.domain.VkFeedPost

sealed class NewsFeedVkScreenState {

    object  Initial: NewsFeedVkScreenState()

    data class Posts(val posts: List<VkFeedPost>) : NewsFeedVkScreenState()

}