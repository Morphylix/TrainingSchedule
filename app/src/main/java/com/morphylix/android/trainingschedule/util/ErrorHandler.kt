package com.morphylix.android.trainingschedule.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.morphylix.android.trainingschedule.R
import retrofit2.HttpException
import java.net.UnknownHostException

object ErrorHandler {

    fun handleException(e: Exception, context: Context): String {
        val error = when (e) {
            is HttpException -> {
                when (e.code()) {
                    404 -> context.getString(R.string.page_not_found)
                    in 500..599 -> context.getString(R.string.server_error)
                    else -> context.getString(R.string.something_went_wrong)
                }
            }
            is UnknownHostException -> {
                context.getString(R.string.no_connection)
            }
            else -> context.getString(R.string.something_went_wrong)
        }
        val errorString = context.getString(R.string.error, error)
        Toast.makeText(context, errorString, Toast.LENGTH_SHORT).show()
        return errorString
    }
}