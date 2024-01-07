package com.example.jetpackcompose.composeElements.vk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkStatisticItem

class VkNewsFeedViewModel : ViewModel() {

    private val sourceList = mutableListOf<VkFeedPost>().apply {
        repeat(10) {
            add(VkFeedPost(id = it))
        }
    }

    private val initialState = NewsFeedVkScreenState.Posts(posts = sourceList)

    private val _screenState = MutableLiveData<NewsFeedVkScreenState>(initialState)
    val screenState: LiveData<NewsFeedVkScreenState> = _screenState

    fun updateCount(feedPost: VkFeedPost, item: VkStatisticItem) {
        val currentState = screenState.value
        if (currentState !is NewsFeedVkScreenState.Posts) return


        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }

        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }

        _screenState.value = NewsFeedVkScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: VkFeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedVkScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = NewsFeedVkScreenState.Posts(posts = oldPosts)
    }

}