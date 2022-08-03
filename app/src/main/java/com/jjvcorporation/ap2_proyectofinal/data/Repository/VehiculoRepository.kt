package com.jjvcorporation.ap2_proyectofinal.data.Repository

import com.jjvcorporation.ap2_proyectofinal.data.Dao.VehiculoDao
import com.jjvcorporation.ap2_proyectofinal.model.Vehiculo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VehiculoRepository @Inject constructor(
    val VehiculoDao: VehiculoDao
) {

    suspend fun insertar(vehiculo: Vehiculo){
        VehiculoDao.insertar(vehiculo)
    }

    suspend fun eliminar(vehiculo: Vehiculo){
        VehiculoDao.eliminar(vehiculo)
    }

    fun buscar(vehiculoId: Int): Flow<Vehiculo> {
        return VehiculoDao.buscar(vehiculoId)
    }

    fun getListVehiculo(): Flow<List<Vehiculo>> {
        return VehiculoDao.getListVehiculo()
    }



}