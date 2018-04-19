package com.baseapp.lc.lc.common

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * 项目名称：LC
 * 类描述：
 * 创建人：chao.liu
 * 创建时间：2018/4/17 下午4:29
 * 修改人：chao.liu
 * 修改时间：2018/4/17 下午4:29
 * 修改备注：
 * @version
 */
abstract class CommonAdapter<D> : RecyclerView.Adapter<CommonAdapter.CommonViewHolder>{
    var datas = ArrayList<D>()

    constructor() : super()

    override fun onBindViewHolder(holder: CommonViewHolder?, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommonViewHolder {
        val dataBinding :ViewDataBinding = getViewDataBinding()
        return CommonViewHolder(dataBinding)
    }
    abstract fun getViewDataBinding() : ViewDataBinding


    override fun getItemCount(): Int {
        if(datas!=null){
            return datas.size
        }else{
            return 0
        }
    }

    class CommonViewHolder (val dataBinding: ViewDataBinding):RecyclerView.ViewHolder(dataBinding.root)

}