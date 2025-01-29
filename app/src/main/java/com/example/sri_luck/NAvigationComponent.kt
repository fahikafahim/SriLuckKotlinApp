package com.example.sri_luck

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 8.dp,
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = MaterialTheme.colorScheme.onBackground) },
            label = { Text("Home", color = MaterialTheme.colorScheme.onBackground) },
            selected = false,
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = MaterialTheme.colorScheme.onBackground) },
            label = { Text("Cart", color = MaterialTheme.colorScheme.onBackground) },
            selected = false,
            onClick = { navController.navigate("cart") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profile", tint = MaterialTheme.colorScheme.onBackground) },
            label = { Text("Profile", color = MaterialTheme.colorScheme.onBackground) },
            selected = false,
            onClick = { navController.navigate("profile") }
        )
    }
}