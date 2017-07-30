package cn.edu.ncist.eyepetizer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.edu.ncist.eyepetizer.R

/**
 * Created by xxl on 2017/7/23.
 */
class HotAdapter(context: Context) : RecyclerView.Adapter<HotAdapter.HotViewHolder>() {
    var context: Context? = null

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HotViewHolder {
        return HotViewHolder(LayoutInflater.from(context)?.inflate(R.layout.item_movie,null))
    }

    override fun onBindViewHolder(holder: HotViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }


    class HotViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}


