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
import com.example.sri_luck.ui.theme.Sri_LuckTheme

@Composable
fun CartPage(navController: NavController) {
    // Main layout for the cart page
    Sri_LuckTheme {
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
                    Text(
                        text = "Your Cart",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(top = 20.dp, bottom = 16.dp)
                    )

                    // Product list
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        CartItem(
                            imageRes = R.drawable.w2,
                            name = "Classic Sneakers",
                            price = "$120.00",
                            details = "Size: 42 • Black"
                        )
                        CartItem(
                            imageRes = R.drawable.p2,
                            name = "Leather Sandals",
                            price = "$85.00",
                            details = "Size: 40 • Brown"
                        )
                    }

                    // Promo code input
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text("Promo Code") },
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(56.dp)
                                .padding(start = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            )
                        ) {
                            Text("Apply")
                        }
                    }

                    // Summary section
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        SummaryRow(label = "Cart Total", value = "$205.00")
                        SummaryRow(label = "Tax", value = "$5.00")
                        SummaryRow(label = "Delivery", value = "$4.99")
                        SummaryRow(label = "Promo Discount", value = "-$0.00")
                        Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))
                        SummaryRow(
                            label = "Subtotal",
                            value = "$214.99",
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
                BottomNavBar(navController = navController)
            }
        }
    }
}

@Composable
fun CartItem(imageRes: Int, name: String, price: String, details: String) {
    // Layout for individual cart item
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
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
    }
}

@Composable
fun SummaryRow(label: String, value: String, textStyle: TextStyle = TextStyle.Default) {
    // Layout for summary rows
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
