package com.info.shoppingapp.presentation.tiles.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.info.shoppingapp.core.databases.SizeX
import com.info.shoppingapp.presentation.components.TextButtonX

@Composable
fun SizeItem(size: SizeX) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.clip(CircleShape),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextButtonX(
                text = size.size,
                backgroundColor = MaterialTheme.colors.background,
                foregroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.size(70.dp)
            )
        }
    }
}