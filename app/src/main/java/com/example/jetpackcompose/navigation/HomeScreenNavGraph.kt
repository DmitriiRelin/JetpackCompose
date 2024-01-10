package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.jetpackcompose.domain.VkFeedPost
import com.google.gson.Gson
import java.lang.RuntimeException

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (VkFeedPost) -> Unit
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedScreenContent()
        }
        composable(
            Screen.Comments.route,
            arguments = listOf(
                navArgument(Screen.KEY_FEED_POST) {
                    type = VkFeedPost.NavigationType
                }
            )
        ) {
            val feedPost = it.arguments?.getParcelable<VkFeedPost>(Screen.KEY_FEED_POST) ?: throw RuntimeException("Args is null")
            //val feedPost = Gson().fromJson(feedPostGson, VkFeedPost::class.java)
            commentsScreenContent(
                feedPost
            )
        }
    }
}