package com.example.test

sealed class NavItem(
    val route : String,
    val title : String,
    val icon : Int
) {
    object Home: NavItem(
        route="home",
        title = "Inicio",
        icon= R.drawable.baseline_home_24
    )
    object Bookmark: NavItem(
        route="bookmark",
        title = "Bookmark",
        icon= R.drawable.baseline_book_24
    )
}