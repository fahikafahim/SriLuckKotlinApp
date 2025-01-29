package com.example.sri_luck.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.example.sri_luck.BottomNavBar
import com.example.sri_luck.DataClasses.Category
import com.example.sri_luck.DataClasses.Product
import com.example.sri_luck.DataSource.HomeDataSource
import com.example.sri_luck.R




// Main layout of the home page, including top bar, banner, categories, recommendations, and bottom navigation
@Composable
fun HomePage(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        TopNavBar()
        BannerSection()
        CategorySection(navController = navController)
        Column(
            modifier = Modifier.weight(1f)
        ) {
            RecommendedSection()
        }
        BottomNavBar(navController = navController)
    }
}

val LightBrown = Color(0xFFD6C0B3)
val DarkBrown = Color(0xFF493628)
val WarmBrown = Color(0xFFAB886D)

// Displays the top navigation bar
@Composable
fun TopNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, top = 36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "SriLuck",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Navigate to Notifications */ }) {
            Icon(
                Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        IconButton(onClick = { /* Navigate to Favorites */ }) {
            Icon(
                Icons.Default.Favorite,
                contentDescription = "Favorites",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
// Banner with discount message and button
@Composable
fun BannerSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Discount 50% for the first transaction",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 9.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Navigate to Shop */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(text = "Shop Now")
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.shop),
            contentDescription = "New Collection Image",
            modifier = Modifier.size(180.dp)
        )
    }
}
// Displays a grid of categories loaded from a data source
@Composable
fun CategorySection(navController: NavController) {
    val homeDataSource = HomeDataSource()
    val categories = homeDataSource.loadCategories()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category = category, navController = navController)
            }
        }
    }
}

// Displays a single category item with an image and label, navigates to the category's route on click
@Composable
fun CategoryItem(category: Category, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                navController.navigate(category.route)
            }
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(category.imageResourceId),
            contentDescription = stringResource(category.labelResourceId),
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(category.labelResourceId),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
// Displays a grid of recommended products loaded from a data source
@Composable
fun RecommendedSection() {
    val homeDataSource = HomeDataSource()
    val products = homeDataSource.loadProducts()

    Column {
        Text(
            text = "Recommended",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products) { product ->
                ProductCard(product = product)
            }
        }
    }
}
// Displays a single product card with an image, name, and price, triggers an action on click
@Composable
fun ProductCard(product: Product, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = LightBrown),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
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
                color = DarkBrown,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Rs. ${product.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = WarmBrown
            )
        }
    }
}
