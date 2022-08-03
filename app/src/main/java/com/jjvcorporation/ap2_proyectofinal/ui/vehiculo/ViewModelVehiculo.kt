package com.jjvcorporation.ap2_proyectofinal.ui.vehiculo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjvcorporation.ap2_proyectofinal.data.Repository.VehiculoRepository
import com.jjvcorporation.ap2_proyectofinal.model.Vehiculo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelVehiculo @Inject constructor(
    val vehiculoRepository: VehiculoRepository

): ViewModel() {
    var id by mutableStateOf(0)
    var vin by mutableStateOf("")
    var marca by mutableStateOf("")
    var modelo by mutableStateOf("")
    var año by mutableStateOf("")

    var vehiculoo by mutableStateOf(Vehiculo(0,"","","",0))



    fun almacen(vehiculo: Vehiculo){
        id = vehiculo.vehiculoId
        vin = vehiculo.vin
        marca = vehiculo.marca
        modelo = vehiculo.modelo
        año = vehiculo.año.toString()
    }


    var vehicul = vehiculoRepository.buscar(id)

    fun getId(Id: Int):Vehiculo{
        viewModelScope.launch {
            vehiculoRepository.buscar(Id).collect{
                vehiculoo = it
            }
        }
        return vehiculoo
    }

    var Vehiculo = vehiculoRepository.getListVehiculo()
        private set

    // var mantenimiento by mutableStateOf(Mantenimiento(1,"",0))
    fun guardar(){
        viewModelScope.launch {
            vehiculoRepository.insertar(
                Vehiculo(
                    vin = vin,
                    marca = marca,
                    modelo = modelo,
                    año = año.toInt()

                )
            )
        }
    }
    fun Guardar(vehiculo: Vehiculo){
        viewModelScope.launch {
            vehiculoRepository.insertar(
                Vehiculo(
                    vin = vehiculo.vin,
                    marca = vehiculo.marca,
                    modelo = vehiculo.modelo,
                    año = vehiculo.año
                )
            )
        }
    }



}
