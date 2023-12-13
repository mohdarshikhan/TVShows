package com.mak.tvshows.ui.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.mak.tvshows.BuildConfig
import com.mak.tvshows.R
import com.mak.tvshows.repo.model.ShowResults

@Composable
fun ShowDetail(
    navController: NavHostController,
    item: ShowResults
) {

    val imageUrl = item.posterPath?.let { "${BuildConfig.THUMBNAIL_BASE_URL}$it" }
    val name = item.name
    val description = item.overview

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (imageUrl != null) {
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        if (name != null) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.labelMedium,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}

@Preview
@Composable
fun PreviewRepoDetail() {
    val navController = rememberNavController()
    ShowDetail(navController, ShowResults())
}
