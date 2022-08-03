package com.jjvcorporation.ap2_proyectofinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mantenimientos")
data class Mantenimiento(
    @PrimaryKey(autoGenerate = true)
    val mantenimientoId: Int = 0,
    val vehiculoId: Int = 0,
    val descripcion: String,
    val periodicidad: Int

)