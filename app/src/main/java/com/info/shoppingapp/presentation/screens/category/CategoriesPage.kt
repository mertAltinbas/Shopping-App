package com.info.shoppingapp.presentation.screens.category

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.info.shoppingapp.core.databases.CategoryFakeData
import com.info.shoppingapp.presentation.components.Subtitle
import com.info.shoppingapp.presentation.components.TextButtonX
import com.info.shoppingapp.presentation.tiles.categories.CategoriesListTile
import com.info.shoppingapp.presentation.ui.theme.ShoppingAppTheme

class CategoriesPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingAppTheme {
                val systemUiController = rememberSystemUiController()
                val isDark = isSystemInDarkTheme()
                val color = colors.background
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = color,
                        darkIcons = !isDark
                    )
                    systemUiController.setNavigationBarColor(
                        color = color,
                        darkIcons = !isDark
                    )
                }
                Categories()
            }
        }
    }

    @SuppressLint("NotConstructor")
    @Composable
    fun Categories() {
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { onBackPressedDispatcher.onBackPressed() }
                    )
                    Subtitle(
                        title = "Categories",
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                    )
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            },
            backgroundColor = colors.background,
        ) { it ->
            Box(modifier = Modifier.padding(it).padding(horizontal = 15.dp)) {
                Column() {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButtonX(
                            text = "Woman",
                            backgroundColor = Color.Transparent,
                            foregroundColor = colors.primary,
                            modifier = Modifier
                                .border(BorderStroke(1.dp, Color.Black),RoundedCornerShape(15.dp))
                                .size(width = 170.dp, height = 55.dp),
                            onTap = {}
                        )
                        TextButtonX(
                            text = "Man",
                            backgroundColor = Color.Transparent,
                            foregroundColor = colors.primary,
                            modifier = Modifier
                                .size(width = 170.dp, height = 55.dp),
                            //.border(BorderStroke(2.dp, Color.Black), RoundedCornerShape(15.dp)),
                            onTap = {}
                        )
                    }

                    Box(Modifier.fillMaxWidth()) {
                        val data = remember { CategoryFakeData.categoryList }
                        val context = LocalContext.current
                        LazyColumn(
                            userScrollEnabled = false,
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp)
                        ) {
                            items(data) {
                                CategoriesListTile(category = it, onTap = {
                                    context.startActivity(Intent(context, CategoriesDetail::class.java))
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}
