package cn.edu.ncist.eyepetizer.mvp.model

import android.content.Context
import cn.edu.ncist.eyepetizer.bean.HomeBean
import cn.edu.ncist.eyepetizer.network.ApiService
import cn.edu.ncist.eyepetizer.network.RetrofitClient
import cn.edu.ncist.eyepetizer.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by xxl on 2017/7/24.
 */
class HomeModel {
    fun loadData(context: Context, isFirstLoad: Boolean,data: String) : Observable<HomeBean>? {
        val retrofit = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofit?.create(ApiService::class.java)
        when(isFirstLoad) {
            true -> return apiService?.getHomeData()

            false -> return apiService?.getHomeMoreData(data,"2")?.applySchedulers()
        }
    }
}