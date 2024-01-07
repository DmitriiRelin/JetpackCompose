package com.example.jetpackcompose.composeElements.vk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkPostComment

class VkCommentsViewModel : ViewModel() {

    private val _screenState = MutableLiveData<CommentsVkScreenState>(CommentsVkScreenState.Initial)
    val screenState: LiveData<CommentsVkScreenState> = _screenState

    init {
        loadComments(VkFeedPost())
    }

    fun loadComments(feedPost: VkFeedPost) {
        val comments = mutableListOf<VkPostComment>().apply {
            repeat(10) {
                add(VkPostComment(id = it))
            }
        }
        _screenState.value = CommentsVkScreenState.Comments(feedPost = feedPost, comments = comments)
    }


}