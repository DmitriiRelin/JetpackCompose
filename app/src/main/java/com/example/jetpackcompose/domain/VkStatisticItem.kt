package com.example.jetpackcompose.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VkStatisticItem(
    val type: StatisticType,
    val count: Int = 0
): Parcelable

enum class StatisticType {
    VIEWS, COMMENTS, SHARES, LIKES
}

