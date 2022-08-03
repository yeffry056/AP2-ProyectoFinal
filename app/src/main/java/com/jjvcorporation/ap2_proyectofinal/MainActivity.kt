package com.jjvcorporation.ap2_proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjvcorporation.ap2_proyectofinal.ui.Componente.Dialog
import com.jjvcorporation.ap2_proyectofinal.ui.Componente.Drawer
import com.jjvcorporation.ap2_proyectofinal.ui.Componente.SplashScreen
import com.jjvcorporation.ap2_proyectofinal.ui.Componente.TopBar
import com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento.ConsultaMantenimiento
import com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento.RegistroMantenimiento
import com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento.dashboarMant
import com.jjvcorporation.ap2_proyectofinal.ui.theme.AP2ProyectoFinalTheme
import com.jjvcorporation.ap2_proyectofinal.ui.vehiculo.ConsultaVehiculo
import com.jjvcorporation.ap2_proyectofinal.ui.vehiculo.RegistroVehiculo
import com.jjvcorporation.ap2_proyectofinal.ui.vehiculo.id
import com.jjvcorporation.ap2_proyectofinal.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import android.window.SplashScreen as SplashScreen1

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AP2ProyectoFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun TallerNelson(
    navController: NavHostController
) {
    val openDialog = remember{ mutableStateOf(false) }
    val id :String ? =  null



    NavHost(navController = navController, startDestination = Screen.goSplash.route){
        composable(route = Screen.goSplash.route){
            SplashScreen(navController = navController)

        }

        composable(route = Screen.IrConsultaVehiculo.route){
            ConsultaVehiculo(IrRegistroVehiculo = { navController.navigate(Screen.IrRegistroVehiculo.route)},
                {newId->
                    //iD = newId
                    navController.navigate(Screen.DashboardMant.createRoute(newId))/*openDialog.value = true*/
                })
        }

        composable(route = Screen.IrRegistroVehiculo.route){
            RegistroVehiculo()
        }
        composable(route = Screen.IrRegistroMantenimiento.route){
            RegistroMantenimiento()
        }
        composable(route = Screen.IrConsultaMantenimiento.route){
            ConsultaMantenimiento(IrRegistroMantenimiento = { navController.navigate(Screen.IrRegistroMantenimiento.route) },)
        }
        composable(route = Screen.DashboardMant.route){ it->
            val newId = it.arguments?.getString("newId")
            dashboarMant(newId!!, openDialog = {openDialog.value = true})
        }


    }
    Dialog(
        //id,
        showDialog = openDialog.value,
        dismissDialog = {openDialog.value = false}
    )


}


@Composable
fun MainScreen() {



    val navController  = rememberNavController()
    val scaffoldState= rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    val scope = rememberCoroutineScope()


    val  navigationItems = listOf(
        Screen.IrConsultaVehiculo,
        Screen.IrRegistroVehiculo,
        Screen.IrConsultaMantenimiento,
        Screen.IrRegistroMantenimiento

    )
    Scaffold(
        scaffoldState = scaffoldState,
       topBar = { TopBar(scope, scaffoldState )},
        drawerContent = { Drawer(scope, scaffoldState, navController, items = navigationItems)},
        drawerGesturesEnabled = true
    ){it!!
        TallerNelson(navController)
    }



}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AP2ProyectoFinalTheme {

    }
}