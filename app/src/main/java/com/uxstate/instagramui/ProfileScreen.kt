package com.uxstate.instagramui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        TopBar(name = "Tonnie_Dev", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection(data = ProfileData(imageId = R.drawable.tonnie))
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
    }
}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
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
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Menu",
            modifier = Modifier.size(20.dp),
            tint = Color.Black
        )

    }
}


@Composable
fun ProfileSection(data: ProfileData, modifier: Modifier = Modifier) {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp)
        ) {

            RoundImage(
                imageId = data.imageId, modifier = Modifier
                        .size(100.dp)
                        .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))


        }
        ProfileDescription(
            displayName = "Tonnie",
            description = "Creative Android Dev who also enjoys Space Science",
            url = "https://www.uxdesign/me",
            followedByList = listOf("GOAT", "Legend"),
            otherCount = 56
        )
    }


}


@Composable
fun RoundImage(@DrawableRes imageId: Int, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        //get the image's height first then adjust width accordingly
        modifier = modifier

                .aspectRatio(1f, matchHeightConstraintsFirst = true)

                .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)

                .padding(3.dp)
                .clip(
                    CircleShape
                )

    )

}


@Composable
fun StatSection(modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "797", text = "Posts")
        ProfileStat(numberText = "113K", text = "Followers")
        ProfileStat(numberText = "87", text = "Following")
    }

}

@Composable
fun ProfileStat(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        //Text 1

        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        //Text 2

        Text(text = text)
    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedByList: List<String>,
    otherCount: Int
) {

    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
    ) {

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(color = 0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight

        )
        if (followedByList.isNotEmpty()) {

            Text(text = buildAnnotatedString {

                //define a bold style

                val boldStyle = SpanStyle(Color.Black, fontWeight = FontWeight.Bold)

                append("Followed by ")

                followedByList.forEachIndexed { i, name ->
                    //push style at the top of the stack
                    pushStyle(boldStyle)

                    //append follower's name
                    append(name)

                    //pop style from stack
                    pop()

                    //append comma if not at the last index

                    if (i < followedByList.lastIndex) {
                        append(", ")

                    }


                }

                if (otherCount > 2) {

                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            }, letterSpacing = letterSpacing, lineHeight = lineHeight)
        }


    }
}


@Composable
fun ButtonSection(modifier: Modifier = Modifier) {

    val minWidth = 95.dp
    // val height = 30.dp

    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {

        //Following Button
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
            /*   .height(height = height)*/
        )

        ActionButton(
            text = "Message",
            modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
            /* .height(height = height)*/
        )


        ActionButton(
            text = "Email",
            modifier = Modifier
                    .defaultMinSize(minWidth = minWidth)
            /*  .height(height = height)*/
        )

        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier

            /*  .height(height = height)*/
        )


    }


}


@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
                .clickable { }
                .padding(6.dp)
    ) {

        if (text != null) {


            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }


        if (icon != null) {

            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }
    }
}


@Composable
fun HighlightSection() {
    HighlightButton(image = painterResource(id = R.drawable.youtube))


}

@Composable
fun HighlightButton(image: Painter, text: String, modifier: Modifier) {
    Column() {
        Image(
            painter = image,
            contentDescription = text,
            modifier = modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
                    .padding(3.dp)
        )
    }
}

@Preview(name = "MyPreview")
@Composable
fun MyPreview() {
    Column(modifier = Modifier.fillMaxSize()) {

        TopBar(name = "Tonnie_Dev")
    }

    ProfileSection(
        data = ProfileData(
            imageId = R.drawable.tonnie,
            posts = 13,
            followers = 13723,
            following = 15032
        )
    )
}