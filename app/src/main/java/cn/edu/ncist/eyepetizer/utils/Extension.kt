package cn.edu.ncist.eyepetizer.utils

import android.app.Activity
import android.content.Intent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by xxl on 2017/7/30.
 */
inline fun <reified T : Activity>Activity.go(){//reified具体化  inline标记为内联函数
    val intent: Intent = Intent(this,T::class.java)
    startActivity(intent)
}
fun <T> Observable<T>.applySchedulers() : Observable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}