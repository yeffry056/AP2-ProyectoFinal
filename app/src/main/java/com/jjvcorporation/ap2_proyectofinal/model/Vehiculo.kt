package com.jjvcorporation.ap2_proyectofinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vehiculos")
data class Vehiculo(
    @PrimaryKey(autoGenerate = true)
    val vehiculoId: Int = 0,
    val vin: String,
    val marca: String,
    val modelo: String,
    val año: Int = 0

)