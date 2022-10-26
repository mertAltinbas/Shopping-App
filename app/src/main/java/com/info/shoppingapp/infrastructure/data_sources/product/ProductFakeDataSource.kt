package com.info.shoppingapp.infrastructure.data_sources.product

import com.info.shoppingapp.R
import com.info.shoppingapp.domain.entities.Product

class ProductFakeDataSource {
    fun getProducts(): List<Product> {
        return List(size = 5) {
            Product(
                title = "Product $it",
                price = 60.00f,
                description = "description",
                image = R.drawable.autumn_coat,
                isLiked = it % 2 == 0,
                sizies = listOf("XS", "S", "M", "L", "XL")
            )
        }
    }
}