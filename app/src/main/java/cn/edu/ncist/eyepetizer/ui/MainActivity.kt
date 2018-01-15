package cn.edu.ncist.eyepetizer.ui

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import cn.edu.ncist.eyepetizer.R
import cn.edu.ncist.eyepetizer.ui.fragment.FindFragment
import cn.edu.ncist.eyepetizer.ui.fragment.HomeFragment
import cn.edu.ncist.eyepetizer.ui.fragment.HotFragment
import cn.edu.ncist.eyepetizer.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var mHomeFragment: HomeFragment? = null
    var mFindFragment: FindFragment? = null
    var mHotFragment:HotFragment?= null
    var mMineFragment:MineFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initToolbar()
        initFragment(savedInstanceState)
    }

    private fun initView() {
        rb_home.isChecked = true
        //supportFragmentManager.beginTransaction().replace(R.id.fl_container, HomeFragment()).commit()
        rb_home.setOnClickListener(this)
        rb_find.setOnClickListener(this)
        rb_hot.setOnClickListener(this)
        rb_mine.setOnClickListener(this)
    }

    @SuppressLint("RestrictedApi")
    private fun initFragment(savedInstanceState: Bundle?) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (savedInstanceState != null) {//程序意外崩溃情况
            val fragments: List<Fragment> = supportFragmentManager.fragments
            for (item in fragments) {
                if (item is HomeFragment) {
                    mHomeFragment = item
                }

                if (item is FindFragment) {
                    mFindFragment = item
                }

                if (item is HotFragment) {
                    mHotFragment = item
                }

                if (item is MineFragment) {
                    mMineFragment = item
                }
            }
        } else {
            mHomeFragment = HomeFragment()
            mFindFragment = FindFragment()
            mHotFragment = HotFragment()
            mMineFragment = MineFragment()

            beginTransaction
                    .add(R.id.fl_container,mHotFragment)
                    .add(R.id.fl_container,mFindFragment)
                    .add(R.id.fl_container,mHotFragment)
                    .add(R.id.fl_container,mMineFragment)
        }

        beginTransaction
                .show(mHomeFragment)
                .hide(mFindFragment)
                .hide(mHotFragment)
                .hide(mMineFragment)
                .commit()
    }

    private fun initToolbar() {
        val typeFace = Typeface.createFromAsset(assets, "fonts/Lobster-1.4.otf")
        tv_title.typeface = typeFace
    }

    override fun onClick(v: View?) {
        clearState()
        val transaction = supportFragmentManager.beginTransaction()
        when (v?.id) {
            R.id.rb_home -> {
                rb_home.isChecked = true
                rb_home.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                transaction.replace(R.id.fl_container, HomeFragment())
            }
            R.id.rb_find -> {
                rb_find.isChecked = true
                rb_find.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                transaction.replace(R.id.fl_container, FindFragment())
            }
            R.id.rb_hot -> {
                rb_hot.isChecked = true
                rb_hot.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                transaction.replace(R.id.fl_container, HotFragment())
            }
            R.id.rb_mine -> {
                rb_mine.isChecked = true
                rb_home.setTextColor(ContextCompat.getColor(this, R.color.colorBlack))
                transaction.replace(R.id.fl_container, MineFragment())
            }
        }
        transaction.commit()
    }

    fun clearState() {
        rb_home.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        rb_find.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        rb_hot.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        rb_mine.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
    }
}
