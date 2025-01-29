package com.example.sri_luck.DataClasses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(
    @StringRes val nameResourceId: Int,   // Name resource ID
    val price: Int,                       // Price value
    @DrawableRes val imageResourceId: Int // Image resource ID
)