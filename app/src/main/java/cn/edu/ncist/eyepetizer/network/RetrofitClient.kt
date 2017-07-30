package cn.edu.ncist.eyepetizer.network

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by xxl on 2017/7/24.
 */
class RetrofitClient(context: Context, url: String) {
    var okHttpClient: OkHttpClient? = null
    var retrofit: Retrofit? = null
    var cache: Cache? = null
    val maxSize: Long = 30 * 24 * 60 * 60
    val DEFAUL_TTIME: Long = 20

    init {
        cache = Cache(context.cacheDir, maxSize)
        //okhttp is created
        okHttpClient = OkHttpClient()
                .newBuilder()
                .cache(cache)//cache
                .addInterceptor(CacheInterceptor(context))
                .addNetworkInterceptor(CacheInterceptor(context))
                .connectTimeout(DEFAUL_TTIME, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAUL_TTIME, TimeUnit.MILLISECONDS)
                .build()

        //retrofit is created
        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {
        //singleton
        fun getInstance(context: Context, url: String): RetrofitClient? {
            var retrofitClient: RetrofitClient? = null
            if (retrofitClient == null) {
                synchronized(RetrofitClient::class.java) {
                    if (retrofitClient == null) {
                        retrofitClient = RetrofitClient(context, url)
                    }
                }
            }
            return retrofitClient
        }
    }

    fun <T> create(service: Class<T>): T? {
        if (service == null) {
            throw RuntimeException("the service is null")
        }
        return retrofit?.create(service)
    }
}