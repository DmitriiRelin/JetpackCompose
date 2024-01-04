package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.composeElements.instagram.InstagramProfileCard
import com.example.jetpackcompose.composeElements.instagram.InstagramViewModel
import com.example.jetpackcompose.composeElements.vk.MainScreen
import com.example.jetpackcompose.composeElements.vk.PostCard
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[InstagramViewModel::class.java]
        setContent {
            ComposeProjectTheme() {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                        .padding(8.dp)

                ) {
                    InstagramProfileCard(viewModel = viewModel)
                }
            }
        }
    }
}