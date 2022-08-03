package com.jjvcorporation.ap2_proyectofinal.data.Dao

import androidx.room.*
import com.jjvcorporation.ap2_proyectofinal.model.Vehiculo
import kotlinx.coroutines.flow.Flow

@Dao
interface VehiculoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(vehiculo: Vehiculo)

    @Delete
    suspend fun eliminar(vehiculo: Vehiculo)

    @Query("SELECT * FROM VEHICULOS WHERE vehiculoId = :vehiculoId")
    fun buscar(vehiculoId: Int): Flow<Vehiculo>

    @Query("SELECT * FROM vehiculos ORDER BY vehiculoId")
    fun getListVehiculo(): Flow<List<Vehiculo>>


}