package com.jjvcorporation.ap2_proyectofinal.ui.Componente

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento
import com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento.ViewModelMantenimiento
import com.jjvcorporation.ap2_proyectofinal.ui.vehiculo.ViewModelVehiculo

var selectedMantenimiento: Mantenimiento? = null

@Composable
fun Dialog(
    //newId: String,
    showDialog: Boolean,
    dismissDialog: ()-> Unit,
    viewModelMantenimiento: ViewModelMantenimiento = hiltViewModel(),
    viewModelVehiculo: ViewModelVehiculo = hiltViewModel()

) {
    val Listmante = viewModelMantenimiento.Mantenimiento.collectAsState(initial = emptyList()).value
    if (showDialog){
        Column() {

            AlertDialog(
                modifier = Modifier
                    .size(350.dp)
                    .height(400.dp),
                onDismissRequest = {},
                /*title = { Text("Titulo del dialogo",
                    style = TextStyle(fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                },*/



                text = {
                    Column() {
                        OutlinedTextField(
                            label = { Text(text = "Fecha Realizado") },
                            value = "",
                            onValueChange = {}




                        )
                        Spacer(modifier = Modifier.size(9.dp))
                        MantenSpinner(Listmante)

                        //Spacer(modifier = Modifier.height(200.dp))
                        OutlinedTextField(
                            label = { Text(text = "Fecha proxima") },
                            value = "",
                            onValueChange = {}


                        )
                    }



                },

                confirmButton = {
                    Button(
                        onClick = {
                            //  viewModelVehiculo.getId(newId.toInt())
                            // viewModelVehiculo.Guardar(viewModelVehiculo.vehiculoo)
                            //guardar antes de cerrar
                            dismissDialog()
                        }
                    ) {
                        Text("Guardar")
                    }
                },
                dismissButton = {
                    Button(onClick = {
                        dismissDialog()
                    }) {
                        Text("Cancelar")
                    }
                }

            )
        }


    }
}

@Composable
fun MantenSpinner(mantenimiento:List<Mantenimiento>){

    var MantenimientoText by remember{ mutableStateOf("Mantenimientos") }
    var expended by remember{ mutableStateOf(false) }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .clickable {
                expended = !expended
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(
                text = MantenimientoText,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 9.dp),
            )
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

            DropdownMenu(
                expanded = expended,
                onDismissRequest = { expended = false},
                modifier = Modifier
                    .background( Color.LightGray))
            {

                mantenimiento.forEach {mantenimiento ->

                    DropdownMenuItem(
                        onClick = {

                            expended = false
                            MantenimientoText = mantenimiento.descripcion
                            selectedMantenimiento = mantenimiento
                        }
                    ) {
                        Text(text = mantenimiento.descripcion)
                        /*OutlinedTextField(
                            value = ocupacionText,
                            onValueChange ={},
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = null)
                            }
                       )*/
                    }
                }

            }
        }
    }
}
