package com.baseapp.lc.lc.ui.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import com.baseapp.lc.lc.R
import com.baseapp.lc.lc.common.CommonAdapter
import com.baseapp.lc.lc.databinding.MainListItemBinding
import com.baseapp.lc.lc.model.MainListModel

/**
 * 项目名称：LC
 * 类描述：
 * 创建人：chao.liu
 * 创建时间：2018/4/17 下午4:54
 * 修改人：chao.liu
 * 修改时间：2018/4/17 下午4:54
 * 修改备注：
 * @version
 */
class MainListAdapterUseCommon :CommonAdapter<MainListModel>{
    constructor() : super()

    override fun getViewDataBinding(): ViewDataBinding {
        val binding : MainListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent!!.context), R.layout.main_list_item,parent,false)
    }
}
