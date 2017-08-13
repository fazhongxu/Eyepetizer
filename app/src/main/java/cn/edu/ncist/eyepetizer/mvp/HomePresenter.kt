package cn.edu.ncist.eyepetizer.mvp

import android.content.Context
import cn.edu.ncist.eyepetizer.bean.HomeBean
import cn.edu.ncist.eyepetizer.mvp.contract.HomeContract
import cn.edu.ncist.eyepetizer.mvp.model.HomeModel
import java.util.*

/**
 * Created by xxl on 2017/7/24.
 */
class HomePresenter constructor(var context: Context) : HomeContract.View, HomeContract.Presenter {

    val mHomeModel : HomeModel by lazy{  //lazy模式，对象要在真正调用的地方才实例化 lazy模式值为val
        HomeModel()
    }


//    var mContext : Context? = null

    init {
//        mContext = context
//        var callback : (()->Unit)? = null   //无参数回调
//        callback?.invoke()

        var callback : ((str : String) -> Unit)? = null  //有参数回调

        callback?.invoke("aaa")

    }

    override fun start() {

    }

    override fun setData(bean: HomeBean) {

    }

    override fun requestData() {
        val subscribe = mHomeModel.loadData(context, true, "0")?.subscribe {

        }
    }
}