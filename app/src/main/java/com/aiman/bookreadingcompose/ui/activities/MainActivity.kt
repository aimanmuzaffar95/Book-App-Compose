package com.aiman.bookreadingcompose.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.ui.tabs.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        val bottomNavigationItems = listOf(
            BottomNavigationScreens.Home,
            BottomNavigationScreens.Browse,
            BottomNavigationScreens.Favourites,
            BottomNavigationScreens.Cart,
        )

        Scaffold(
            bottomBar = {
                BooksBottomNavigation(navController, bottomNavigationItems)
            }
        ) {
            MainScreenNavigationConfigurations(navController)
        }
    }

    @Composable
    fun BooksBottomNavigation (
        navController: NavHostController,
        items: List<BottomNavigationScreens>) {

        BottomNavigation {
            val currentRoute = currentRoute(navController)
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon, null) },
                    label = { Text(stringResource(id = screen.resourceId)) },
                    selected = currentRoute == screen.route,
                    alwaysShowLabel = false,
                    onClick = {
                        if(currentRoute != screen.route) {
                            navController.navigate(screen.route)
                        }
                    },
                    modifier = Modifier.background(color = colorResource(id = R.color.bottom_bar_color)),
                    selectedContentColor = colorResource(id = R.color.icon_highlight),
                    unselectedContentColor = colorResource(id = R.color.icon_color)
                )
            }
        }
    }

    @Composable
    private fun currentRoute(navController: NavHostController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    }

    @Composable
    private fun MainScreenNavigationConfigurations(
        navController: NavHostController
    ) {
        NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
            composable(BottomNavigationScreens.Home.route) {
                HomeTab(this@MainActivity)
            }
            composable(BottomNavigationScreens.Browse.route) {
                BrowseTab()
            }
            composable(BottomNavigationScreens.Favourites.route) {
                FavouritesTab()
            }
            composable(BottomNavigationScreens.Cart.route) {
                CartTab()
            }
        }
    }

}
