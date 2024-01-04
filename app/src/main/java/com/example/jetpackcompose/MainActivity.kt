package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.composeElements.instagram.InstagramViewModel
import com.example.jetpackcompose.composeElements.vk.VkMainScreen
import com.example.jetpackcompose.composeElements.vk.VkViewModel
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {

    //private val instagramViewModel = ViewModelProvider(this)[InstagramViewModel::class.java]
    private val vkViewModel by viewModels<VkViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme() {
                VkMainScreen(vkViewModel)
            }
        }
    }
}