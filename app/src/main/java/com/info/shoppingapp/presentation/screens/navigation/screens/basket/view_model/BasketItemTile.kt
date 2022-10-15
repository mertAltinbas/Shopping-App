package com.info.shoppingapp.presentation.screens.navigation.screens.basket.view_model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.info.shoppingapp.domain.entities.Product

@Composable
fun BasketItemList(data: Product) {
    var value by remember { mutableStateOf(1) }

    Surface(
        color = colors.background,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .fillMaxSize()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                Surface(
                    modifier = Modifier
                        .size(83.dp)
                        .clip(RoundedCornerShape(15.dp)),
                )
                {
                    Image(
                        modifier = Modifier.clip(RoundedCornerShape(15.dp)),
                        painter = painterResource(id = data.image),
                        contentDescription = null,
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

            Column()
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { if (value != 1) value-- }) {
                        Text(
                            text = "-",
                            fontSize = 65.sp,
                            color = colors.primaryVariant,
                            fontWeight = FontWeight.Thin
                        )
                    }

                    Text(
                        text = "$value",
                        fontWeight = FontWeight.Medium,
                        fontSize = 25.sp
                    )

                    TextButton(onClick = { value++ }) {
                        Text(
                            text = "+",
                            fontSize = 35.sp,
                            color = colors.primaryVariant,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
            }
        }
    }
}