package com.jjvcorporation.ap2_proyectofinal.data.Dao

import androidx.room.*
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento
import kotlinx.coroutines.flow.Flow

@Dao
interface MantenimientoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(mantenimiento: Mantenimiento)

    @Delete
    suspend fun eliminar(mantenimiento: Mantenimiento)

    @Query("SELECT * FROM Mantenimientos WHERE mantenimientoId = :mantenimientoId")
    fun buscar(mantenimientoId: Int): Flow<Mantenimiento>

    @Query("SELECT * FROM Mantenimientos ORDER BY mantenimientoId")
    fun getListMantenimiento(): Flow<List<Mantenimiento>>
}