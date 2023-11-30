package com.example.recyclerview_khoapham

import android.annotation.SuppressLint
import android.text.format.DateFormat
import java.text.SimpleDateFormat

class DateUtil {
    companion object {

        /**
         * Convert date to millisecond
         * Example: 20/11/2023 => 1700413200000
         * @param date [String]
         * @return [Long]
         */
        @SuppressLint("SimpleDateFormat")
        fun convertDateToMillisecond(date: String): Long {
            return SimpleDateFormat("dd/MM/yyyy").parse(date)?.time ?: 0
        }

        /**
         * Convert millisecond to String
         * Example: 1700413200000 => 20/11/2023
         * @param milliSeconds [Long]
         * @return [String]
         */
        fun convertMilliSecondToString(milliSeconds: Long): String {
            return DateFormat.format("dd/MM/yyyy", milliSeconds).toString();
        }
    }
}