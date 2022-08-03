package com.jjvcorporation.ap2_proyectofinal.data.Repository

import com.jjvcorporation.ap2_proyectofinal.data.Dao.MantenimientoDao
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MantenimientoRepository @Inject constructor(
    val mantenimientoDao: MantenimientoDao
) {
    suspend fun insertar(mantenimiento: Mantenimiento){
        mantenimientoDao.insertar(mantenimiento)
    }

    suspend fun eliminar(mantenimiento: Mantenimiento){
        mantenimientoDao.eliminar(mantenimiento)
    }

    fun buscar(mantenimientoId: Int): Flow<Mantenimiento> {
        return mantenimientoDao.buscar(mantenimientoId)
    }

    fun getListMantenimiento(): Flow<List<Mantenimiento>> {
        return mantenimientoDao.getListMantenimiento()
    }
}