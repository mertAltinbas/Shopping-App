package com.info.shoppingapp.presentation.tiles.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.info.shoppingapp.domain.entities.Category

@Composable
fun HomeCategory(category: Category, onTap: (() -> Unit) = {} ) {

    Surface(color = colors.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.clickable(onClick = onTap)
        ) {
            Surface(
                modifier = Modifier.size(63.dp).clip(CircleShape),
                color = colors.surface
            )
            {
                Image(
                    modifier = Modifier.padding(17.dp),
                    painter = painterResource(id = category.image),
                    contentDescription = null,
                )
            }
            Text(
                text = category.category,
                color = colors.primary,
                fontSize = 16.sp
            )
        }
    }
}