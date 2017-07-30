package cn.edu.ncist.eyepetizer.mvp.contract

import cn.edu.ncist.eyepetizer.bean.HomeBean
import cn.edu.ncist.eyepetizer.mvp.BasePresenter
import cn.edu.ncist.eyepetizer.mvp.BaseView

/**
 * Created by xxl on 2017/7/24.
 */
interface HomeContract {
    interface View : BaseView<Presenter> {
        fun setData(bean: HomeBean)
    }
    interface Presenter : BasePresenter{
        fun requestData()
    }
}