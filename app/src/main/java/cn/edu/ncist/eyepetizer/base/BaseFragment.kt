package cn.edu.ncist.eyepetizer.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by xxl on 2017/7/23.
 */
open abstract class BaseFragment : Fragment() {
    var rootView: View? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater?.inflate(getLayoutId(), container,false)
        }
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData()
}