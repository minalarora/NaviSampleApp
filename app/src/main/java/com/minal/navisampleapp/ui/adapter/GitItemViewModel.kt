package com.minal.navisampleapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import com.minal.navisampleapp.R
import com.minal.navisampleapp.data.model.Git
import java.lang.Exception
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
private val outputDateFormat = SimpleDateFormat("dd MMM yy");
@SuppressLint("SimpleDateFormat")
private val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

class GitItemViewModel(context: Context, private val git: Git) {

        val title = git.title ?: context.getString(R.string.empty_string)

        val createdText = context.getString(
            R.string.created_text,
            changeDateFormat(git.createdAt) ?: context.getString(R.string.empty_string)
        )

        val closedText =  context.getString(
            R.string.closed_text,
            git.number ?: context.getString(R.string.empty_string),
                        git.user?.title ?: context.getString(R.string.empty_string),
                        changeDateFormat(git.updatedAt) ?: context.getString(R.string.empty_string)
        )

        val avatarUrl = git.user?.avatar ?: context.getString(R.string.empty_string)

       private fun changeDateFormat(dateString: String?) : String? {
           return try {
               val date = inputDateFormat.parse(dateString)
               return outputDateFormat.format(date)
           } catch (ex: Exception) {
               null
           }
       }

}

