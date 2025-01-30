package com.example.sri_luck

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sri_luck.pages.CartPage
import com.example.sri_luck.pages.HomePage
import com.example.sri_luck.pages.LoginPage
import com.example.sri_luck.pages.ProfilePage
import com.example.sri_luck.pages.SignupPage
import com.example.sri_luck.pages.KidsCategoryScreen
import com.example.sri_luck.pages.MenCategoryScreen
import com.example.sri_luck.pages.ProductDetailPage
import com.example.sri_luck.pages.WomenCategoryScreen

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
   val navController = rememberNavController() // Navigation controller

   // Define the navigation host and routes
   NavHost(navController = navController, startDestination = "splash") {

      // Splash Screen Route
      composable("splash") {
         SplashScreen(navController)
      }

      // Login Screen Route
      composable("login") {
         LoginPage(navController)
      }

      // Home Screen Route
      composable("home") {
         HomePage(navController)
      }

      // Signup Screen Route
      composable("signup") {
         SignupPage(navController)
      }

      // Cart Page Route
      composable("cart") {
         CartPage(navController)
      }

      // Profile Page Route
      composable("profile") {
         ProfilePage(navController)
      }

      // Category Pages Routes
      composable("women") { WomenCategoryScreen(navController) }
      composable("men") { MenCategoryScreen(navController) }
      composable("kids") { KidsCategoryScreen(navController) }

      // Product Detail Page Route with dynamic parameters
      composable("productDetail/{nameResourceId}/{price}/{imageResourceId}") { backStackEntry ->
         backStackEntry.arguments?.let { args ->
            val nameResourceId = args.getString("nameResourceId")?.toIntOrNull()
            val price = args.getString("price")?.toIntOrNull()
            val imageResourceId = args.getString("imageResourceId")?.toIntOrNull()

            if (nameResourceId != null && price != null && imageResourceId != null) {
               ProductDetailPage(nameResourceId, price, imageResourceId, navController)
            }
         }
      }
   }
}
