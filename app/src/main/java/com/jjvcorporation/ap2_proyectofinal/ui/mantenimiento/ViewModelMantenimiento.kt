package com.jjvcorporation.ap2_proyectofinal.ui.mantenimiento

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjvcorporation.ap2_proyectofinal.data.Repository.MantenimientoRepository
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelMantenimiento @Inject constructor(
    val mantenimientoRepository: MantenimientoRepository
): ViewModel() {

    var Periodicidad by mutableStateOf("")
    var tipoMantenimiento by mutableStateOf("")
    //poner nombre de parametro
    var mantenimiento by mutableStateOf(Mantenimiento(0,0, "",0))

    var Mantenimiento = mantenimientoRepository.getListMantenimiento()
        private set

    fun getId(id: Int): Mantenimiento{
        viewModelScope.launch {
            mantenimientoRepository.buscar(id).collect{
                mantenimiento = it
            }
        }
        return mantenimiento
    }


    fun Inicializar(mantenimientos : List<Mantenimiento>){
        viewModelScope.launch {
            List(mantenimientos.size){
                mantenimientoRepository.insertar(

                    Mantenimiento(

                        mantenimientoId = mantenimientos[it].mantenimientoId,
                        descripcion =  mantenimientos[it].descripcion,
                        periodicidad = mantenimientos[it].periodicidad

                    )

                )

            }

        }
    }

    fun guardar(){
        viewModelScope.launch {
            mantenimientoRepository.insertar(
                Mantenimiento(
                    periodicidad = Periodicidad.toInt(),
                    descripcion = tipoMantenimiento


                )
            )
        }
    }
}