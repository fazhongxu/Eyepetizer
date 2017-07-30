package cn.edu.ncist.eyepetizer.network

import android.app.usage.NetworkStatsManager
import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by xxl on 2017/7/25.
 */
class NetWork {
    companion object {
        fun isNetConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo == null) {
                return false
            } else {
                return activeNetworkInfo.isAvailable && activeNetworkInfo.isAvailable
            }
        }
    }
}