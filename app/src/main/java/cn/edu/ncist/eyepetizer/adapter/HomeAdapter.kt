package cn.edu.ncist.eyepetizer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.edu.ncist.eyepetizer.R
import cn.edu.ncist.eyepetizer.bean.HomeBean

/**
 * Created by xxl on 2017/7/23.
 */
class HomeAdapter constructor(val context: Context,val homeBean:HomeBean) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, null, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }

    class HomeViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var ivPhoto: ImageView? = null

        init {
            ivPhoto = itemView?.findViewById(R.id.iv_photo) as ImageView
        }
    }
}

