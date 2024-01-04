package com.example.jetpackcompose.composeElements.vk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkStatisticItem
import java.lang.IllegalStateException

class VkViewModel: ViewModel() {

    private val _feedPost = MutableLiveData(VkFeedPost())
    val feedPost: LiveData<VkFeedPost> = _feedPost

    fun updateCount(item: VkStatisticItem) {
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
    }

}