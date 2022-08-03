package com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import java.util.*

@Composable
fun RegistroMantenimiento(
    viewModel: ViewModelMantenimiento = hiltViewModel()
) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val focusPeriodicidad = FocusRequester()
    val focusTipoMantenimiento = FocusRequester()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Mantenimientos") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {



                    if (viewModel.Periodicidad.isNullOrEmpty()) {
                        Toast.makeText(context, "Periodicidad Vacio", Toast.LENGTH_SHORT).show()
                        focusPeriodicidad.requestFocus()
                        return@FloatingActionButton
                    }
                    if (viewModel.tipoMantenimiento.isNullOrEmpty()) {
                        Toast.makeText(context, "Descripcion vacio", Toast.LENGTH_SHORT).show()
                        focusTipoMantenimiento.requestFocus()
                        return@FloatingActionButton
                    }


                    viewModel.guardar()
                    viewModel.Periodicidad = ""
                    viewModel.tipoMantenimiento = ""
                    focusTipoMantenimiento.requestFocus()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = null)
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {


            OutlinedTextField(
                label = {
                    Text(text = "Descripcion")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = viewModel.tipoMantenimiento,
                onValueChange = {viewModel.tipoMantenimiento = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusTipoMantenimiento)
            )
            OutlinedTextField(
                label = {
                    Text(text = "Periodicidad")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Timer, contentDescription = null)
                },
                value = viewModel.Periodicidad,
                onValueChange = {if(it.length < 3)viewModel.Periodicidad = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusPeriodicidad)
            )
        }
    }
}

@Composable
fun ShowDatePicker(context: Context) {
    val year: Int
    val month: Int
    val day: Int

    val calender = Calendar.getInstance()

    year = calender.get(Calendar.YEAR)
    month = calender.get(Calendar.MONTH)
    day = calender.get(Calendar.DAY_OF_MONTH)
    calender.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { Fecha: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day

    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Fecha : ${date.value}")
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {
                datePickerDialog.show()
            }
        ) {
            Text(text = "Fecha")
        }
    }


}