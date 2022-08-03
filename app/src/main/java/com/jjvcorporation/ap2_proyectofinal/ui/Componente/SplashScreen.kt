package com.jjvcorporation.ap2_proyectofinal.ui.Componente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jjvcorporation.ap2_proyectofinal.R
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento
import com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento.ViewModelMantenimiento
import com.jjvcorporation.ap2_proyectofinal.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModelMantenimiento: ViewModelMantenimiento = hiltViewModel()
) {
   /* val mantenimiento =listOf<Mantenimiento>(
        Mantenimiento(mantenimientoId = 1,"Cambio de Aceite",3 ),
        Mantenimiento(mantenimientoId = 2,"Rotacion de Gomas",7 ),
        Mantenimiento(mantenimientoId = 3,"Chequeo de Fluidos",1 ),
        Mantenimiento(mantenimientoId = 4,"Chequeo de Gomas",1 )

    )*/


    LaunchedEffect(key1 = true){
        /// viewModelMantenimiento.Inicializar(mantenimiento)
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screen.IrConsultaVehiculo.route)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.maintenance256_24835),
            contentDescription = "Logo",
            Modifier.size(150.dp, 150.dp))

        Text(text = "Bienvenidos",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }

}