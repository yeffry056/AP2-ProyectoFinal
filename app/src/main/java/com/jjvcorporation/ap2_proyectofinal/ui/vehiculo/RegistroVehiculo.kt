package com.jjvcorporation.ap2_proyectofinal.ui.vehiculo

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

val focusVin = FocusRequester()
val focusMarca = FocusRequester()
val focusModelo = FocusRequester()
val focusAño = FocusRequester()

@Composable
fun RegistroVehiculo(
    viewModelVehiculo: ViewModelVehiculo = hiltViewModel()

) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()



    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de vehiculos") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (viewModelVehiculo.vin.isNullOrEmpty()) {
                        Toast.makeText(context, "Vin Vacio", Toast.LENGTH_SHORT).show()
                        focusVin.requestFocus()
                        return@FloatingActionButton
                    }
                    if (viewModelVehiculo.marca.isNullOrEmpty()) {
                        Toast.makeText(context, "Marca vacio", Toast.LENGTH_SHORT).show()
                        focusMarca.requestFocus()
                        return@FloatingActionButton
                    }
                    if (viewModelVehiculo.modelo.isNullOrEmpty()) {
                        Toast.makeText(context, "Modelo vacio", Toast.LENGTH_SHORT).show()
                        focusModelo.requestFocus()
                        return@FloatingActionButton
                    }
                    if (viewModelVehiculo.año.isNullOrEmpty()) {
                        Toast.makeText(context, "Año vacio", Toast.LENGTH_SHORT).show()
                        focusAño.requestFocus()
                        return@FloatingActionButton
                    }

                    viewModelVehiculo.guardar()
                    viewModelVehiculo.vin = ""
                    viewModelVehiculo.marca = ""
                    viewModelVehiculo.modelo = ""
                    viewModelVehiculo.año = ""
                    focusVin.requestFocus()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = null)
            }


        },
    ) {




        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {



        }

    }
    MostrarFoto()


}

@Composable
fun MostrarFoto(
    viewModelVehiculo : ViewModelVehiculo = hiltViewModel()
){


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),

        ){
        Column(modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {


            OutlinedTextField(
                label = {
                    Text(text = "Vin")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = viewModelVehiculo.vin,
                onValueChange = {if(it.length < 18) viewModelVehiculo.vin = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusVin)
            )
            OutlinedTextField(
                label = {
                    Text(text = "Marca")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.BrightnessAuto, contentDescription = null)
                },
                value = viewModelVehiculo.marca,
                onValueChange = {viewModelVehiculo.marca = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusMarca)
            )
            OutlinedTextField(
                label = {
                    Text(text = "Modelo")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.CarRepair, contentDescription = null)
                },
                value = viewModelVehiculo.modelo,
                onValueChange = {viewModelVehiculo.modelo = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusModelo)
            )
            /*OutlinedTextField(
                label = {
                    Text(text = "Modelo")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = viewModelVehiculo.modelo,
                onValueChange = {viewModelVehiculo.modelo = it},
                modifier = Modifier.fillMaxWidth().focusRequester(focusModelo)
            )*/
            OutlinedTextField(
                label = {
                    Text(text = "Año")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Timelapse, contentDescription = null)
                },
                value = viewModelVehiculo.año,
                onValueChange = {if(it.length < 5)viewModelVehiculo.año = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusAño)
            )



        }
    }

}