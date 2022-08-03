package com.jjvcorporation.ap2_proyectofinal.di

import android.content.Context
import androidx.room.Room
import com.jjvcorporation.ap2_proyectofinal.data.Dao.MantenimientoDao
import com.jjvcorporation.ap2_proyectofinal.data.Dao.VehiculoDao
import com.jjvcorporation.ap2_proyectofinal.data.Repository.MantenimientoRepository
import com.jjvcorporation.ap2_proyectofinal.data.Repository.VehiculoRepository
import com.jjvcorporation.ap2_proyectofinal.data.TallerDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProvideTallerDb(@ApplicationContext context: Context): TallerDb {
        return Room.databaseBuilder(
            context,
            TallerDb::class.java,
            "TallerNelsonDb"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    fun ProvidesVehiculoRepository(vehiculoDao: VehiculoDao): VehiculoRepository {
        return VehiculoRepository(vehiculoDao)
    }

    @Provides
    fun ProvidesVehiculo(tallerDb: TallerDb): VehiculoDao {
        return tallerDb.vehiculoDao
    }
    /////

    @Provides
    fun ProvidesMantenimientoRepository(mantenimientoDao: MantenimientoDao): MantenimientoRepository {
        return MantenimientoRepository(mantenimientoDao)
    }

    @Provides
    fun ProvidesMantenimiento(tallerDb: TallerDb): MantenimientoDao {
        return tallerDb.mantenimientoDao
    }
}