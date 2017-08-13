package cn.edu.ncist.eyepetizer.network

import cn.edu.ncist.eyepetizer.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by xxl on 2017/7/30.
 */
interface ApiService {
    companion object {
        val BASE_URL : String
        get() = "http://baobab.kaiyanapp.com/api/"
    }

    //获取首页第一页数据
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData() : Observable<HomeBean>

    @GET("v2/feed")
    fun getHomeMoreData(@Query("date") data : String,@Query("num") num : String) : Observable<HomeBean>
}