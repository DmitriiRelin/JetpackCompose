package com.example.jetpackcompose.composeElements.vk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkStatisticItem
import java.lang.IllegalStateException

class VkViewModel : ViewModel() {

    private val sourceList = mutableListOf<VkFeedPost>().apply {
        repeat(10) {
            add(VkFeedPost(id = it))
        }
    }
    private val _feedPosts = MutableLiveData<List<VkFeedPost>>(sourceList)
    val feedPosts: LiveData<List<VkFeedPost>> = _feedPosts

    fun updateCount(feedPost: VkFeedPost, item: VkStatisticItem) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
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
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
    }

    fun remove(feedPost: VkFeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        oldPosts.remove(feedPost)
        _feedPosts.value = oldPosts
    }

}