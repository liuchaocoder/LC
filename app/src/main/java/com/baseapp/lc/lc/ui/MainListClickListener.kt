package com.baseapp.lc.lc.ui

import com.baseapp.lc.lc.model.MainListModel

/**
 * 项目名称：LC
 * 类描述：主列表点击监听
 * 创建人：chao.liu
 * 创建时间：2018/4/2 下午4:37
 * 修改人：chao.liu
 * 修改时间：2018/4/2 下午4:37
 * 修改备注：
 * @version
 */
interface MainListClickListener {
    fun onClick(mainListModel: MainListModel)
}