package com.minal.navisampleapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minal.navisampleapp.data.model.Git

@Dao
interface GitDao {

    @Query("SELECT * FROM git")
    fun getPullRequest(): LiveData<List<Git>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(gits: List<Git>)
}