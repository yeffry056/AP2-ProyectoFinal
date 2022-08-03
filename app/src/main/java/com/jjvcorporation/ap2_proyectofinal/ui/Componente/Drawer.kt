package com.jjvcorporation.ap2_proyectofinal.ui.Componente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jjvcorporation.ap2_proyectofinal.util.Screen
import com.jjvcorporation.ap2_proyectofinal.util.currentRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.jjvcorporation.ap2_proyectofinal.R.drawable

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    items: List<Screen>
) {
    Column {

        Image(painter = painterResource(id = com.jjvcorporation.ap2_proyectofinal.R.drawable.ic_launcher_background),
            contentDescription = "Bg Image",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

        val currentRoute = currentRoute(navController)
        items.forEach{item->
            DrawerItem(item = item, selectd = currentRoute == item.route){
                navController.navigate(item.route){
                    launchSingleTop= true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }

        }
    }



}

@Composable
fun DrawerItem(
    item: Screen,
    selectd: Boolean,
    onItemClick:(Screen)-> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(6.dp)
        .clip(RoundedCornerShape(12))
        .background(
            if (selectd)
                Color.Blue.copy(alpha = 0.25f)
            else
                Color.Transparent
        )
        .padding(8.dp)
        .clickable { onItemClick(item) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = item.icon,
            contentDescription = item.tittle,
            tint = if (selectd)
                Color.Blue
            else
                Color.Black
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text =item.tittle,
            style = TextStyle(fontSize = 18.sp),
            color = if (selectd)
                Color.Blue
            else
                Color.Black
        )

    }
}