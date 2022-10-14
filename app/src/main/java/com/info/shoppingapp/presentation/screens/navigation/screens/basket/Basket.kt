package com.info.shoppingapp.presentation.screens.navigation.screens.basket

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.info.shoppingapp.presentation.components.Subtitle
import com.info.shoppingapp.presentation.components.TextButtonX

@Composable
fun BasketView() {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { }
                    )
                }
                Column(Modifier.weight(1.5f)) {
                    Subtitle(
                        title = "Basket",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        ),
                    )
                }
            }
        },
        backgroundColor = colors.background,
    ) {
        Box(Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                Box {
                    Surface() {

                    }
                    Column {
                        Spacer(
                            modifier = Modifier
                                .aspectRatio(1.2f)
                        )
                        Surface(
                            shape = RoundedCornerShape(30.dp, 30.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 15.dp)
                            ) {
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 5.dp, horizontal = 25.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Order Info",
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colors.primary
                                    )
                                }

                                Column(Modifier.padding(vertical = 25.dp, horizontal = 25.dp)) {
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Bright beret (M)",
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                            color = Color.DarkGray
                                        )
                                        Text(
                                            text = "1 item",
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                            color = Color.DarkGray
                                        )
                                    }

                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 15.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Delivery",
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                            color = Color.DarkGray
                                        )
                                        Text(
                                            text = "$ 10.00",
                                            style = TextStyle(
                                                fontSize = 25.sp,
                                                fontWeight = FontWeight.Bold
                                            ),
                                            color = colors.primary
                                        )
                                    }

                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 35.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Price",
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                            color = Color.DarkGray
                                        )
                                        Text(
                                            text = "$ 750.00",
                                            style = TextStyle(
                                                fontSize = 25.sp,
                                                fontWeight = FontWeight.Bold
                                            ),
                                            color = MaterialTheme.colors.primary
                                        )
                                    }

                                    BottomNavigation(
                                        backgroundColor = MaterialTheme.colors.surface,
                                        elevation = 0.dp,
                                        modifier = Modifier
                                            .padding(bottom = 80.dp)
                                            .height(70.dp)
                                    ) {
                                        Row(
                                            Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            TextButtonX(
                                                text = "Placing an Order",
                                                modifier = Modifier
                                                    .size(width = 260.dp, height = 90.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
