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
   val navController = rememberNavController()

   NavHost(navController = navController, startDestination = "splash") {
      composable("splash") {
         SplashScreen(navController)
      }
      composable("login") {
         LoginPage(navController)
      }
      composable("home") {
         HomePage(navController)
      }
      composable("signup") {
         SignupPage(navController)
      }
      composable("cart") {
         CartPage(navController)
      }
      composable("profile") {
         ProfilePage(navController)
      }
      composable("women") { WomenCategoryScreen(navController) }
      composable("men") { MenCategoryScreen(navController) }
      composable("kids") { KidsCategoryScreen(navController) }
      composable(
         "productDetail/{nameResourceId}/{price}/{imageResourceId}"
      ) { backStackEntry ->
         val nameResourceId = backStackEntry.arguments?.getString("nameResourceId")?.toInt()
         val price = backStackEntry.arguments?.getString("price")?.toInt()
         val imageResourceId = backStackEntry.arguments?.getString("imageResourceId")?.toInt()

         if (nameResourceId != null && price != null && imageResourceId != null) {
            ProductDetailPage(
               nameResourceId = nameResourceId,
               price = price,
               imageResourceId = imageResourceId,
               navController = navController
            )
         }
      }
   }
}
