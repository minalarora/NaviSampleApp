package com.minal.navisampleapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "git")
data class Git(

    @PrimaryKey
    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("number")
    val number: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("user")
    val user: User? = null,
)


data class User(

    @field:SerializedName("login")
    val title: String? = null,

    @field:SerializedName("avatar_url")
    val avatar: String? = null,
)