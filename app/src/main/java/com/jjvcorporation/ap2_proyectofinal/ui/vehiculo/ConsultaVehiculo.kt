package com.jjvcorporation.ap2_proyectofinal.ui.vehiculo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjvcorporation.ap2_proyectofinal.model.Vehiculo

var id by mutableStateOf("")
@Composable
fun ConsultaVehiculo(
    IrRegistroVehiculo : () ->Unit,
    dashboardMante: (String) -> Unit,
    viewModel : ViewModelVehiculo = hiltViewModel()
) {
    var idText by remember{ mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta vehiculo") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    IrRegistroVehiculo()
                }) {
                Icon(imageVector = Icons.Default.AddCard, contentDescription = null)
            }
        },
        scaffoldState = rememberScaffoldState()
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {
            //  val ListVehiculo = viewModelVehiculo.Vehiculo.collectAsState(initial = emptyList()).value
            val ListVehiculo = viewModel.Vehiculo.collectAsState(initial = emptyList()).value
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(ListVehiculo){vehiculo ->
                    RowVehiculo(vehiculo = vehiculo,{},dashboardMante)
                }
            }
        }

    }
}

fun traslado(id: String): String{
    return id
}
@Composable
fun RowVehiculo(
    vehiculo: Vehiculo,
    onClick : (Vehiculo) -> Unit,
    dashboardMante: (String)-> Unit,

    viewModel : ViewModelVehiculo = hiltViewModel()

) {
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp).clickable { onClick(vehiculo) }.clickable { dashboardMante(vehiculo.vehiculoId.toString()) },
            horizontalArrangement = Arrangement.SpaceBetween


        ) {
            Row() {
                //Imagen
            }
            Text(
                text = vehiculo.marca,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left
            )
            Text(
                text = vehiculo.modelo,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left
            )
            Text(
                text = "${vehiculo.año}",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Right
            )

        }

    }
}