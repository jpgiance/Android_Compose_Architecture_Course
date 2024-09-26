package com.jorgegiance.myapplication.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jorgegiance.myapplication.question.FavoriteQuestion

@Database(
    entities = [
        FavoriteQuestion::class
    ],
    version = 1
)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract val favoriteQuestionDao: FavoriteQuestionDao
}