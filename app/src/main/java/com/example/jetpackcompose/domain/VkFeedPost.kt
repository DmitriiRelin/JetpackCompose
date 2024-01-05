package com.example.jetpackcompose.domain

import com.example.jetpackcompose.R

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
)