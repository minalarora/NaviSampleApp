package com.minal.navisampleapp.base

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.minal.navisampleapp.data.model.User


/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {

    @TypeConverter fun stringToUser(userString: String): User {
        val gson = GsonBuilder().create()
        return gson.fromJson(userString, User::class.java)
    }

    @TypeConverter fun userToString(user: User): String {
        val gson = GsonBuilder().create()
        return gson.toJson(user)
    }

}