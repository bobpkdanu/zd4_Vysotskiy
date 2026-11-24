package com.example.prak4_vysotskiy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Crime::class], version = 2, exportSchema = false)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDataBase : RoomDatabase() {

    abstract fun crimeDao(): CrimeDao

    companion object {
        @Volatile private var obj: CrimeDataBase? = null

        fun getInstance(context: Context): CrimeDataBase =
            obj ?: synchronized(this) {
                obj ?: Room.databaseBuilder(
                    context.applicationContext,
                    CrimeDataBase::class.java,
                    "basa.db"
                ).build().also { obj = it }
            }
    }
}
