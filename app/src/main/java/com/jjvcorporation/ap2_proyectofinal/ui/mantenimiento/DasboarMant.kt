package com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjvcorporation.ap2_proyectofinal.ui.vehiculo.ViewModelVehiculo

@Composable
fun dashboarMant(
    newId: String,
    viewModel : ViewModelMantenimiento = hiltViewModel(),
    viewModelVehicu: ViewModelVehiculo = hiltViewModel(),
    openDialog: (String)-> Unit
) {
    viewModelVehicu.getId(newId.toInt())


    val ListMantenimiento = viewModel.Mantenimiento.collectAsState(initial = emptyList()).value
    //val newVehicul = viewModelVehicu.vehicul.collectAsState(initial = emptyList<Vehiculo>()).value

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp
    ) {
        Column {

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),
                horizontalArrangement = Arrangement.SpaceBetween


            ) {
                Text(
                    text = viewModelVehicu.vehiculoo.marca,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Left
                )
                Text(
                    text = viewModelVehicu.vehiculoo.modelo,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Left
                )
                Text(
                    text = "${viewModelVehicu.vehiculoo.año}",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Right
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.SpaceBetween


            ) {
                Text(text = "T. Mant",
                    modifier = Modifier,
                    Color.Unspecified
                )
                Text(text = "P. Fecha",
                    modifier = Modifier,
                    Color.Cyan
                )
            }
            LazyColumn(){
                items(ListMantenimiento){item ->


                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(text = item.descripcion)

                        if(item.periodicidad  == 1){
                            Text(text = "${item.periodicidad.toString()} mes")
                        }else{
                            Text(text = "${item.periodicidad.toString()} meses")
                        }

                    }

                }
            }

            Button(
                onClick = { openDialog(newId) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.AppRegistration, contentDescription = null)
                Text(text = "Reg. Mant. Realizado")

            }
        }

    }






}