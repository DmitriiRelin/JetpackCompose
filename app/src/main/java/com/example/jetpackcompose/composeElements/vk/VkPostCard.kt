package com.example.jetpackcompose.composeElements.vk

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.domain.StatisticType
import com.example.jetpackcompose.domain.VkFeedPost
import com.example.jetpackcompose.domain.VkStatisticItem
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme
import java.lang.IllegalStateException

@Composable
fun PostCard(
    modifier: Modifier = Modifier, feedPost: VkFeedPost,
    onLickClickListener: (VkStatisticItem) -> Unit,
    onShareClickListener: (VkStatisticItem) -> Unit,
    onCommentClickListener: (VkStatisticItem) -> Unit,
    onViewsClickListener: (VkStatisticItem) -> Unit,
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            PostHeader(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = feedPost.contentText)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), painter = painterResource(
                    id = feedPost.contentImageResId
                ), contentDescription = null, contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics(
                statistics = feedPost.statistics,
                onLickClickListener = onLickClickListener,
                onShareClickListener = onShareClickListener,
                onCommentClickListener = onCommentClickListener,
                onViewsClickListener = onViewsClickListener
            )
        }
    }
}

@Composable
private fun PostHeader(feedPost: VkFeedPost) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape), painter = painterResource(id = feedPost.avatarResId), contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = feedPost.communityName, color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = feedPost.publicationDate, color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert, contentDescription = null, tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun Statistics(
    statistics: List<VkStatisticItem>,
    onLickClickListener: (VkStatisticItem) -> Unit,
    onShareClickListener: (VkStatisticItem) -> Unit,
    onCommentClickListener: (VkStatisticItem) -> Unit,
    onViewsClickListener: (VkStatisticItem) -> Unit,
) {

    Row() {
        Row(modifier = Modifier.weight(1f)) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithText(iconResId = R.drawable.ic_views_count, text = viewsItem.count.toString(), onItemClickListener = {
                onViewsClickListener(viewsItem)
            })
        }
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            IconWithText(iconResId = R.drawable.ic_share, text = sharesItem.count.toString(), onItemClickListener = {
                onShareClickListener(sharesItem)
            })
            val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithText(iconResId = R.drawable.ic_comment, text = commentsItem.count.toString(), onItemClickListener = {
                onCommentClickListener(commentsItem)
            })
            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithText(iconResId = R.drawable.ic_like, text = likesItem.count.toString(), onItemClickListener = {
                onLickClickListener(likesItem)
            })
        }
    }
}

private fun List<VkStatisticItem>.getItemByType(type: StatisticType): VkStatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException()
}

@Composable
private fun IconWithText(
    iconResId: Int, text: String, onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            onItemClickListener()
        }, verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResId), contentDescription = null, tint = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text, color = MaterialTheme.colors.onSecondary
        )
    }
}


@Preview
@Composable
private fun PreviewLight() {
    ComposeProjectTheme(darkTheme = false) {
        //PostCard()
    }
}

@Preview
@Composable
private fun PreviewDark() {
    ComposeProjectTheme(darkTheme = true) {
        //PostCard()
    }
}