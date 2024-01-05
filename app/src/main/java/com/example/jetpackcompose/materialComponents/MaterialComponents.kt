package com.example.jetpackcompose.materialComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.composeElements.instagram.InstagramProfileCard
import com.example.jetpackcompose.composeElements.instagram.InstagramViewModel
import com.example.jetpackcompose.ui.theme.ComposeProjectTheme
import kotlinx.coroutines.launch

@Preview
@Composable
fun ButtonExample() {
    OutlinedButton(onClick = {}) {
        Text(text = "Hello")
    }
}

@Preview
@Composable
fun TextFieldExample() {
    TextField(value = "Value", onValueChange = {}, label = { Text(text = "Label") })
}

@Preview
@Composable
fun AlertDialogExample() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Text(modifier = Modifier.padding(8.dp), text = "Yes")
        },
        title = {
            Text(text = "Are you sure?")
        },
        text = {
            Text(text = "Do you want to delete this file?")
        },
        dismissButton = {
            Text(modifier = Modifier.padding(8.dp), text = "No")
        })
}

@Preview
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "TopAppBar title")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                })
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }, label = {
                        Text(text = "Favorite")
                    })
                BottomNavigationItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.Edit, contentDescription = null)
                    }, label = {
                        Text(text = "Edit")
                    })
                BottomNavigationItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Filled.Delete, contentDescription = null)
                    }, label = {
                        Text(text = "Delete")
                    })
            }
        },
        drawerContent = {
            Text(text = "Text1")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Text2")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Text3")
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold content"
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LazyColumnExample(viewModel: InstagramViewModel) {
    ComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
            LazyColumn {
                items(models.value, key = { it.id }) { model ->
                    val dismissState = rememberDismissState()

                    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                        viewModel.delete(model = model)
                    }

                    SwipeToDismiss(
                        state = dismissState,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                                    .background(Color.Red.copy(alpha = 0.5f)),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = "Delete item",
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                        }
                    ) {
                        InstagramProfileCard(
                            model = model,
                            onFollowedButtonClickListener = {
                                viewModel.changeFollowingStatus(it)
                            }
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun LazyRowExample(viewModel: InstagramViewModel) {
    ComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
            LazyRow {
                items(models.value) { model ->
                    InstagramProfileCard(
                        model = model,
                        onFollowedButtonClickListener = {
                            viewModel.changeFollowingStatus(it)
                        }
                    )
                }
            }
        }
    }
}


