package com.info.shoppingapp.presentation.screens.navigation.screens.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.info.shoppingapp.domain.repositories.IProductRepository
import com.info.shoppingapp.infrastructure.data_sources.product.ProductFakeDataSource
import com.info.shoppingapp.infrastructure.data_sources.product.ProductLocalDataSource
import com.info.shoppingapp.infrastructure.data_sources.product.ProductRemoteDataSource
import com.info.shoppingapp.infrastructure.repositories.ProductRepository
import com.info.shoppingapp.presentation.components.Subtitle
import com.info.shoppingapp.presentation.screens.product.ProductDetail
import com.info.shoppingapp.presentation.tiles.favorites.FavoritesDetailListTile

private val repository : IProductRepository = ProductRepository(ProductRemoteDataSource(), ProductLocalDataSource(), ProductFakeDataSource())

@Composable
fun FavoriteScreen() {
    DetailView()
}

@Composable
fun DetailView() {
    val context = LocalContext.current
    Scaffold()
    { padding ->
        val detail = remember { repository.getProducts() }
        Box(modifier = Modifier
            .padding(padding)
            .padding(top = 20.dp)) {
            LazyVerticalGrid(
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                columns = GridCells.Fixed(1)
            ) {
                items(detail) {
                    FavoritesDetailListTile(detail = it, onTap = {
                        context.startActivity(ProductDetail.newIntent(context, it))
                    })
                }
            }
        }
    }
}
