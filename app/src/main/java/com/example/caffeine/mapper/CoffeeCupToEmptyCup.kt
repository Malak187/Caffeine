package com.example.caffeine.mapper

import com.example.caffeine.R

fun  Int.toEmptyCup(coffeePhoto: Int): Int{
    return when(coffeePhoto){
        R.drawable.im_espresso_coffee -> R.drawable.espresso_empty_cup
        R.drawable.im_black_coffee -> R.drawable.black_empty_cup
        R.drawable.im_lattee_coffee -> R.drawable.latte_empty_cup
        R.drawable.im_macchiato_coffee -> R.drawable.macchiato_empty_cup
        else -> R.drawable.espresso_empty_cup
    }
}

fun Int.toCoffeeLid(coffeePhoto: Int): Int{
    return when(coffeePhoto){
        R.drawable.espresso_empty_cup -> R.drawable.espresso_cover
        R.drawable.black_empty_cup -> R.drawable.black_cover
        R.drawable.latte_empty_cup -> R.drawable.lattee_cover
        R.drawable.macchiato_empty_cup -> R.drawable.macchiato_cover
        else -> R.drawable.espresso_cover
    }
}