package com.jjvcorporation.ap2_proyectofinal.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjvcorporation.ap2_proyectofinal.data.Dao.MantenimientoDao
import com.jjvcorporation.ap2_proyectofinal.data.Dao.VehiculoDao
import com.jjvcorporation.ap2_proyectofinal.model.Mantenimiento
import com.jjvcorporation.ap2_proyectofinal.model.Vehiculo

@Database(
entities = [
    Vehiculo::class,
    Mantenimiento::class
],
exportSchema = false,
version = 1
)

abstract class TallerDb: RoomDatabase() {
    abstract  val vehiculoDao: VehiculoDao
    abstract  val mantenimientoDao: MantenimientoDao
}