package com.example.sri_luck.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sri_luck.BottomNavBar
import com.example.sri_luck.R

@Composable
fun CartPage(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(25.dp)) {
                // Title section
                Text(
                    text = "Your Cart",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(top = 20.dp, bottom = 16.dp)
                )
                // Cart product list section
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    CartItem(
                        imageRes = R.drawable.w1,
                        name = "Women Sandal",
                        price = "Rs. 1250",
                        details = "Color: Pink"
                    )
                    CartItem(
                        imageRes = R.drawable.m1,
                        name = "Men Sandal",
                        price = "Rs. 2250",
                        details = "Color: Black"
                    )
                    CartItem(
                        imageRes = R.drawable.k3,
                        name = "Kids Sandal",
                        price = "Rs. 1200",
                        details = "Color: Black"
                    )
                }

                //  Order summary section
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    SummaryRow(label = "Cart Total", value = "Rs. 4700")
                    SummaryRow(label = "Tax", value = "Rs. 100")
                    SummaryRow(label = "Delivery", value = "Rs. 500")
                    SummaryRow(label = "Promo Discount", value = "-Rs. 0")
                    Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))
                    SummaryRow(
                        label = "Subtotal",
                        value = "Rs. 5300",
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    )
                }

                // Checkout button
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        "Proceed to Checkout",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            // Bottom navigation bar
            BottomNavBar(navController = navController)
        }
    }
}
// Individual cart item section
@Composable
fun CartItem(imageRes: Int, name: String, price: String, details: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Remove item */ },
            modifier = Modifier
                .size(24.dp)
                .padding(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.re),
                contentDescription = "Remove Item",
                tint = MaterialTheme.colorScheme.error
            )
        }
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = details,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}

// Order summary row section
@Composable
fun SummaryRow(label: String, value: String, textStyle: TextStyle = TextStyle.Default) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = textStyle.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Text(
            text = value,
            style = textStyle.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}
