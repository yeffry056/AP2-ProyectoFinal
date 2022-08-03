package com.jjvcorporation.ap2_proyectofinal.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val tittle:String,
    val icon: ImageVector
) {
    object IrConsultaVehiculo : Screen("IrConsultaVehiculo", "Consulta Vehiculo", Icons.Filled.Home)
    object IrRegistroMantenimiento : Screen("IrRegistroMantenimiento", "Registro Mantenimiento", Icons.Filled.AppRegistration)
    object IrRegistroVehiculo : Screen("IrRegistroVehiculo", "Registro Vehiculo", Icons.Filled.CarRental)
    //------------------------------------------------------------------------
    object IrConsultaMantenimiento : Screen("IrConsultaMantenimiento", "Consulta Mantenimiento", Icons.Filled.QueryStats)
    object goSplash : Screen("goSplash","Logo", Icons.Filled.Login)
    object DashboardMant : Screen("DashboardMant/{newId}", "Dashboard Mantenimiento", Icons.Filled.ManageAccounts){
        fun createRoute(newId: String)="DashboardMant/$newId"
    }

    //
    // object Menu : Screen("Menu")
    //  object IMAG : Screen("Imag")
}