package com.example.sri_luck.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sri_luck.DataSource.HomeDataSource
import com.example.sri_luck.DataClasses.Product
import com.example.sri_luck.R
//List of Women's products displayed in a grid
@Composable
fun WomenCategoryScreen(navController: NavController) {
    val homeDataSource = HomeDataSource()
    val womenProducts = homeDataSource.loadWomenProducts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 36.dp, top = 16.dp)
    ) {
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Text(
                text = "Women's Products",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(womenProducts) { product ->
                WomenProductCard(product = product)
            }
        }
    }
}
//Composable function to display a single product card
@Composable
fun WomenProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE7D5CC)), // Soft Beige
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageResourceId),
                contentDescription = stringResource(id = product.nameResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = product.nameResourceId),
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF6A4A3C),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Rs. ${product.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFA07C67)
            )
        }
    }
}
