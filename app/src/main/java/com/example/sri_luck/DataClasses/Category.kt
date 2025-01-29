package com.example.sri_luck.DataClasses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @StringRes val labelResourceId: Int,  // Label resource ID
    @DrawableRes val imageResourceId: Int ,// Image resource ID
    val route: String // Route property
)
