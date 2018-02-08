package cn.edu.ncist.eyepetizer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.edu.ncist.eyepetizer.R
import cn.edu.ncist.eyepetizer.adapter.HomeAdapter
import cn.edu.ncist.eyepetizer.base.BaseFragment
import cn.edu.ncist.eyepetizer.bean.HomeBean
import cn.edu.ncist.eyepetizer.mvp.HomePresenter
import cn.edu.ncist.eyepetizer.mvp.contract.HomeContract
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by xxl on 2017/7/23.
 */
class HomeFragment : BaseFragment(),HomeContract.View{

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        //请求数据
        HomePresenter(context,this).requestData()
    }
    //绑定数据
    override fun setData(homeBean: HomeBean) {
        recyclerView.adapter = HomeAdapter(context,homeBean)
    }


}