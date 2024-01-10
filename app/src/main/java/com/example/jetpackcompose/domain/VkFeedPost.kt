package com.example.jetpackcompose.domain

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.example.jetpackcompose.R
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class VkFeedPost(
    val id: Int = 0,
    val communityName: String = "dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<VkStatisticItem> = listOf(
        VkStatisticItem(type = StatisticType.LIKES, count = 34),
        VkStatisticItem(type = StatisticType.VIEWS, count = 200),
        VkStatisticItem(type = StatisticType.SHARES, count = 123),
        VkStatisticItem(type = StatisticType.COMMENTS, count = 998),
    )
) : Parcelable {
    companion object {
        val NavigationType: NavType<VkFeedPost> = object : NavType<VkFeedPost>(false) {
            override fun get(bundle: Bundle, key: String): VkFeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): VkFeedPost {
                return Gson().fromJson(value, VkFeedPost::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: VkFeedPost) {
                bundle.putParcelable(key, value)
            }
        }
    }
}