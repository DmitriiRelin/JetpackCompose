package com.example.jetpackcompose.composeElements.vk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.domain.VkFeedPost

class VkCommentsViewModelFactory(
    private val feedPost: VkFeedPost
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VkCommentsViewModel(feedPost) as T
    }

}