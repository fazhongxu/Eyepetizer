package cn.edu.ncist.eyepetizer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.edu.ncist.eyepetizer.R
import cn.edu.ncist.eyepetizer.adapter.HomeAdapter
import cn.edu.ncist.eyepetizer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by xxl on 2017/7/23.
 */
class HomeFragment : BaseFragment(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HomeAdapter(context)
    }


}