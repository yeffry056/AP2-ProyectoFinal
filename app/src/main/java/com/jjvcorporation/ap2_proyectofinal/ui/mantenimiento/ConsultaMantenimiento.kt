package com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento

@Composable
fun ConsultaMantenimiento(
    IrRegistroMantenimiento: ()-> Unit,
    viewModelMantenimiento: ViewModelMantenimiento = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Tipos de Mantenimiento") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    IrRegistroMantenimiento()
                }) {
                Icon(imageVector = Icons.Filled.AppRegistration, contentDescription = null)
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {
            val ListMantenimiento = viewModelMantenimiento.Mantenimiento.collectAsState(initial = emptyList()).value
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(ListMantenimiento){mantenimiento ->
                    RowMantenimiento(mantenimiento = mantenimiento)
                }
            }
        }

    }
}

@Composable
fun RowMantenimiento(
    mantenimiento: Mantenimiento
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = mantenimiento.descripcion,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left
            )

            Text(
                text = "${mantenimiento.periodicidad}",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Right
            )

        }

    }
}