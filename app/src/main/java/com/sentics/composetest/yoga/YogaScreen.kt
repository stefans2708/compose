package com.sentics.composetest.yoga

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.yoga.theme_soothe.MySootheTheme
import com.sentics.composetest.yoga.section.FavoritesGrid
import com.sentics.composetest.yoga.section.HomeSection
import com.sentics.composetest.yoga.section.TopWorkoutsRow

@Composable
fun YogaScreen(modifier: Modifier = Modifier) {
    when (LocalConfiguration.current.orientation) {

        Configuration.ORIENTATION_PORTRAIT -> {
            Scaffold(
                bottomBar = { YogaBottomBar() },
                content = { Content(modifier.padding(it)) }
            )
        }

        else -> {
            Surface(color = MaterialTheme.colorScheme.background) {
                Row {
                    YogaNavigationRail()
                    Content(modifier = modifier)
                }
            }
        }
    }
}

@Composable
private fun Content(modifier: Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp)) {}
        HomeSection(title = R.string.soothe_align_your_body) {
            TopWorkoutsRow()
        }
        HomeSection(title = R.string.soothe_favorite_collections) {
            FavoritesGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun YogaBottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.soothe_bottom_navigation_home)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(text = stringResource(id = R.string.soothe_bottom_navigation_profile)) }
        )
    }
}

@Composable
fun YogaNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            NavigationRailItem(
                selected = true,
                onClick = { },
                icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = null) },
                label = { Text(text = stringResource(id = R.string.soothe_bottom_navigation_home)) }
            )
            NavigationRailItem(
                selected = false,
                onClick = { },
                icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
                label = { Text(text = stringResource(id = R.string.soothe_bottom_navigation_profile)) }
            )
        }
    }
}

@Preview
@Preview(heightDp = 360, widthDp = 800)
@Composable
private fun YogaScreenPreview() {
    MySootheTheme {
        YogaScreen()
    }
}
