package cn.edu.ncist.eyepetizer.network

import android.content.Context
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by xxl on 2017/7/25.
 */
class CacheInterceptor(var context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var maxAge = 60//设置最大缓存时间
        var request = chain?.request()
        if (NetWork.isNetConnected(context)) {//有网络缓存60秒
            return chain?.proceed(request)
                    ?.newBuilder()
                    ?.removeHeader("Pragma")
                    ?.removeHeader("Cache-Control")
                    ?.header("Cache-Control", "max-age=" + maxAge)
                    ?.build()
        } else {//没有网络，强制走本地缓存，设置可以访问过期缓存
            request = request?.newBuilder()?.cacheControl(CacheControl.FORCE_CACHE)?.build()
            var maxStale = 60 * 60 * 24 * 3
            val response = chain?.proceed(request)
            return response?.newBuilder()
                    ?.removeHeader("Pragma")
                    ?.removeHeader("Cache-Control")
                    ?.header("Cache-Control", "max-stale" + maxStale)?.build()//可以使用过期的缓存

        }
    }
}