package com.example.sri_luck.DataSource
import com.example.sri_luck.R
import com.example.sri_luck.DataClasses.Category
import com.example.sri_luck.DataClasses.Product

class HomeDataSource {
    fun loadCategories(): List<Category> {
        return listOf(
            Category(R.string.women_category, R.drawable.women3,"women"),
            Category(R.string.men_category, R.drawable.men1,"men"),
            Category(R.string.children_category, R.drawable.kid2,"kids")
        )
    }

    fun loadProducts(): List<Product> {
        return listOf(
            Product(R.string.leather_men_footwear, 3000, R.drawable.x3),
            Product(R.string.leather_footwear, 3000, R.drawable.x1),
            Product(R.string.leather_footwear, 3000, R.drawable.x6),
            Product(R.string.leather_footwear, 3000, R.drawable.x7),
            Product(R.string.leather_men_footwear, 3000, R.drawable.x8),
            Product(R.string.leather_footwear, 3000, R.drawable.k10),
            Product(R.string.leather_footwear, 3000, R.drawable.w8)
        )
    }


    fun loadMenProducts(): List<Product> {
        return listOf(
            // Men's Products
            Product(R.string.men_shoes1, 2500, R.drawable.m1),
            Product(R.string.men_shoes2, 2800, R.drawable.m2),
            Product(R.string.men_shoes3, 3000, R.drawable.m3),
            Product(R.string.men_shoes4, 3200, R.drawable.m4),
            Product(R.string.men_shoes5, 3500, R.drawable.m5),
            Product(R.string.men_shoes6, 2700, R.drawable.m6),
            Product(R.string.men_shoes7, 2900, R.drawable.m7),
            Product(R.string.men_shoes8, 3100, R.drawable.m8),
            Product(R.string.men_shoes9, 3300, R.drawable.m9),
            Product(R.string.men_shoes10, 3600, R.drawable.m10)


        )
    }
    fun loadWomenProducts(): List<Product> {
        return listOf(

            // Women's Products
            Product(R.string.women_shoes1, 2200, R.drawable.w1),
            Product(R.string.women_shoes2, 2400, R.drawable.w2),
            Product(R.string.women_shoes3, 2600, R.drawable.w3),
            Product(R.string.women_shoes4, 2800, R.drawable.w4),
            Product(R.string.women_shoes5, 3000, R.drawable.w5),
            Product(R.string.women_shoes6, 3200, R.drawable.w6),
            Product(R.string.women_shoes7, 3400, R.drawable.w7),
            Product(R.string.women_shoes8, 3600, R.drawable.w8),
            Product(R.string.women_shoes9, 3800, R.drawable.w9),
            Product(R.string.women_shoes10, 4000, R.drawable.w1)

        )
    }
    fun loadKidsProducts(): List<Product> {
        return listOf(
                       // Kids' Products
            Product(R.string.kids_shoes1, 1500, R.drawable.k1),
            Product(R.string.kids_shoes2, 1600, R.drawable.k2),
            Product(R.string.kids_shoes3, 1700, R.drawable.k3),
            Product(R.string.kids_shoes4, 1800, R.drawable.k4),
            Product(R.string.kids_shoes5, 1900, R.drawable.k5),
            Product(R.string.kids_shoes6, 2000, R.drawable.k6),
            Product(R.string.kids_shoes7, 2100, R.drawable.k7),
            Product(R.string.kids_shoes8, 2200, R.drawable.k8),
            Product(R.string.kids_shoes9, 2300, R.drawable.k9),
            Product(R.string.kids_shoes10, 2400, R.drawable.k10)
        )
    }



}