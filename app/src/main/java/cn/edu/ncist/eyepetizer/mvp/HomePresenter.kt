package cn.edu.ncist.eyepetizer.mvp

import android.content.Context
import cn.edu.ncist.eyepetizer.mvp.contract.HomeContract
import cn.edu.ncist.eyepetizer.mvp.model.HomeModel
import cn.edu.ncist.eyepetizer.utils.applySchedulers

/**
 * Created by xxl on 2017/7/24.
 */
class HomePresenter constructor(var context: Context,var view:HomeContract.View) : HomeContract.Presenter {

    val mHomeModel: HomeModel by lazy {
        //lazy模式，对象要在真正调用的地方才实例化 lazy模式值为val
        HomeModel()
    }

    init {

    }

    override fun start() {

    }

    override fun requestData() {
        mHomeModel
                .loadData(context, true, "0")
                /* ?.subscribeOn(Schedulers.io())
                 ?.observeOn(AndroidSchedulers.mainThread())*/
                ?.applySchedulers()
                ?.subscribe { homeBean ->
                   view.setData(homeBean)
                }
    }
}