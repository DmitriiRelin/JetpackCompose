package com.example.jetpackcompose.composeElements.instagram

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme


@Composable
fun InstagramProfileCard(
    viewModel: InstagramViewModel
) {

    val isFollowed = viewModel.isFollowing.observeAsState(false)
    //val isFollowed by viewModel.isFollowing.observeAsState(false)


    Card(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp)
                )

                UserStatistics(title = "Posts", value = "5.304")
                UserStatistics(title = "Followers", value = "435M")
                UserStatistics(title = "Following", value = "76")
            }
            Text(
                text = "Instagram",
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive
            )
            Text(
                text = "#YoursToMake",
                fontSize = 14.sp,
            )
            Text(
                text = "http://www.twitch.tv",
                fontSize = 14.sp,
            )
            FollowButton(isFollowed = isFollowed) {
                viewModel.changeFollowingStatus()
            }
        }
    }
}


@Composable
private fun FollowButton(
    isFollowed: State<Boolean>,
    clickListener: () -> Unit
) {
    Button(
        onClick = {
            clickListener()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isFollowed.value) {
                MaterialTheme.colors.primary.copy(
                    alpha = 0.5F
                )
            } else {
                MaterialTheme.colors.primary
            }
        )
    ) {
        val text = if (isFollowed.value) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(text = text)
    }
}


@Composable
private fun UserStatistics(title: String, value: String) {
    Column(
        modifier = Modifier
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview
@Composable
fun PreviewCardLight() {
    ComposeProjectTheme(darkTheme = false) {
        //  InstagramProfileCard()
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    ComposeProjectTheme(darkTheme = true) {
        //   InstagramProfileCard()
    }
}