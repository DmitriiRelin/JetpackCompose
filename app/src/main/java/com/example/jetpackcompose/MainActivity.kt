package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.composeElements.instagram.InstagramProfileCard
import com.example.jetpackcompose.composeElements.instagram.InstagramViewModel
import com.example.jetpackcompose.composeElements.vk.VkMainScreen
import com.example.jetpackcompose.composeElements.vk.VkViewModel
import com.example.jetpackcompose.materialComponents.LazyColumnExample
import com.example.jetpackcompose.materialComponents.LazyRowExample
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {

    private val instagramViewModel by viewModels<InstagramViewModel>()
    private val vkViewModel by viewModels<VkViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowExample(instagramViewModel)
        }
    }
}