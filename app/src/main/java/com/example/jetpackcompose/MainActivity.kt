package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.jetpackcompose.composeElements.instagram.InstagramViewModel
import com.example.jetpackcompose.composeElements.vk.VkMainScreen
import com.example.jetpackcompose.composeElements.vk.VkNewsFeedViewModel
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme() {
                VkMainScreen()
            }
        }
    }
}