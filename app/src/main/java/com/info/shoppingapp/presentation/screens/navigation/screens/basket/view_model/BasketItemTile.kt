package com.info.shoppingapp.presentation.screens.navigation.screens.basket.view_model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.info.shoppingapp.domain.entities.Category
import com.info.shoppingapp.domain.entities.Product

@Composable
fun BasketItemList(data: Product) {
    Surface(
        color = colors.surface,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .fillMaxSize()
            .height(100.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                Surface(
                    modifier = Modifier.size(83.dp),
                )
                {
                    Image(
                        painter = painterResource(id = data.image),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter
                    )
                }
                Column() {
                    Column(Modifier.padding(vertical = 5.dp)) {
                        Text(
                            text = data.title,
                            color = colors.primaryVariant,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = "(M)", color = colors.primaryVariant,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                    Text(
                        text = "$ " + data.price.toString(), color = colors.primary,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }

            Column(Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = colors.primaryVariant,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Composable
fun Calculator(data: Product) {
    var value by remember { mutableStateOf(0) }
    var price = value * data.price
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(color = colors.surface)
            .padding(horizontal = 16.dp)
    ) {
        TextButton(onClick = { if (value != 0) value-- }, elevation = null)
        {
            Text(text = "-", color = Color.Black, fontSize = 25.sp)
        }

        Text(
            text = "$value",
            Modifier.padding(16.dp),
            fontWeight = FontWeight.Medium
        )

        TextButton(onClick = { value++ }, elevation = null)
        {
            Text(text = "+", color = Color.Black, fontSize = 25.sp)
            Text(text = price.toString())
        }
    }
}