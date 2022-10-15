package com.info.shoppingapp.presentation.tiles.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.info.shoppingapp.domain.entities.Product


@Composable
fun NewItemsListTile(data: Product, onTap: (() -> Unit) = { }) {
    Column {
        Box(
            modifier = Modifier.clickable(onClick = onTap)
        ) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(.76f)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )
            Surface(
                shape = CircleShape,
                color = colors.onSurface,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 10.dp, end = 10.dp)
                    .clickable { }
                    .size(35.dp)
            ) {
                Icon(
                    imageVector = if (data.isLiked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
        Column(modifier = Modifier.padding(vertical = 5.dp)) {
            Text(
                text = data.title,
                fontSize = 16.sp,
                color = colors.primaryVariant
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$ " + data.price.toString(),
                    textAlign = TextAlign.Start,
                    color = colors.primary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}