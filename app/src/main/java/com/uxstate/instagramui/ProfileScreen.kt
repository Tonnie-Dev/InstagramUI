package com.uxstate.instagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        TopBar(name = "Tonnie_Dev")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection(
            data = ProfileData(
                image = R.drawable.tonnie,
                posts = 13,
                followers = 13723,
                following = 15032
            )
        )
    }
}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxSize()
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Sub",
            tint = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Menu",
            tint = Color.Black
        )

    }
}


@Composable
fun ProfileSection(data: ProfileData, modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
    ) {

        Image(
            painter = painterResource(id = data.image),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )

        Column {

            Text(text = data.posts.toString(), fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "posts",  fontSize = 16.sp)
        }

        Column {

            Text(text = data.followers.toString(), fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "posts",  fontSize = 16.sp)
        }
    }


}

@Preview(name = "MyPreview")
@Composable
fun MyPreview() {
    Column(modifier = Modifier.fillMaxSize()) {

        TopBar(name = "Tonnie_Dev")
    }
}