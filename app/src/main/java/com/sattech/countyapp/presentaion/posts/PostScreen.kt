package com.sattech.countyapp.presentaion.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sattech.countyapp.domain.model.Post


@Composable
fun PostScreen(viewModel: PostViewModel = hiltViewModel()) {
    val result = viewModel.posts.value

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error.toString())
        }
    }
    result.posts?.let {
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            item {
                it.map { PostListItems(it) }
            }
        }
    }
}

@Composable
fun PostListItems(post: Post) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = post.title,
            modifier = Modifier.padding(4.dp),
            style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = post.title,
            modifier = Modifier.padding(4.dp),
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )
    }
}