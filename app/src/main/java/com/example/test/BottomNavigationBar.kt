package com.example.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.test.ui.theme.primary
import com.example.test.ui.theme.primaryContainer
import com.example.test.ui.theme.secondary
import com.example.test.ui.theme.secondaryContainer
import com.example.test.ui.theme.surfaceAccent
import com.example.test.ui.theme.surfaceVariant

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val item = listOf(
        NavItem.Home,
        NavItem.Bookmark
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(100.dp),
        containerColor = surfaceVariant
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        item.forEach{ item ->
            NavigationBarItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = "", modifier = Modifier.size(28.dp))
                },
                label = {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )},
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(top = 10.dp, bottom = 10.dp),
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = surfaceAccent
                )
            )
        }

    }

}