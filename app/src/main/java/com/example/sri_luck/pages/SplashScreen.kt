package com.example.sri_luck

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sri_luck.ui.theme.backgroundDark
import com.example.sri_luck.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.sri_luck.ui.theme.secondaryLight
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var isVisible by remember { mutableStateOf(false) }

    // Animate scale and opacity
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 3000, easing = LinearEasing),
        label = "Alpha Animation"
    )

    LaunchedEffect(Unit) {
        isVisible = true
        delay(3000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.we2),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )

            // Main content
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                // Welcome message
                Text(
                    text = "Welcome",
                    fontSize = 38.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold,
                    color = backgroundDark ,
                    modifier = Modifier
                        .alpha(alpha)
                        .padding(start = 200.dp)
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "to SriLuck",
                    fontSize = 38.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold,
                    color = backgroundDark ,
                    modifier = Modifier
                        .alpha(alpha)
                        .padding(start = 200.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))


                // Subtitle
                Text(
                    text = "Step into comfort and style with our exclusive collection",
                    fontSize = 16.sp,

                    color = onSurfaceVariantLightMediumContrast ,
                    modifier = Modifier
                        .alpha(alpha)
                        .padding(start = 200.dp)
                )
            }
        }
    }
}
