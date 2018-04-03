package com.baseapp.lc.lc.ui

import android.arch.lifecycle.Lifecycle
import android.content.ContentValues.TAG
import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.baseapp.lc.lc.MainActivity

import com.baseapp.lc.lc.R
import com.baseapp.lc.lc.databinding.MainListFragmentBinding
import com.baseapp.lc.lc.model.MainListModel
import com.baseapp.lc.lc.ui.adapter.MainListAdapter
import java.lang.RuntimeException
import java.util.*


class MainListFragment : Fragment() {
    lateinit var mainListAdapter: MainListAdapter
    lateinit var mBinding: MainListFragmentBinding
    /*采用对象表达式来创建接口对象，即匿名内部类的实例。 */
    val mMainListClickCallback = object: MainListClickListener {
        override fun onClick(mainListModel: MainListModel){
            Log.d(TAG,"匿名内部类形式增加监听")
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.main_list_fragment,container,false)
        mainListAdapter = MainListAdapter(mMainListClickCallback)
        mBinding.productsList.adapter =mainListAdapter
        return mBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLists = ArrayList<MainListModel>()
        mainLists.add(MainListModel("1","2"))
        mainLists.add(MainListModel("3","4"))
        mainLists.add(MainListModel("5","6"))
        mainListAdapter.setMainList(mainLists)
        Log.d(TAG,"${mainLists.size}")
        mBinding.executePendingBindings()
    }

    companion object {
        val TAG = MainListFragment::class.java.simpleName
    }
}
