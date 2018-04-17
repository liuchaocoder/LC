package com.baseapp.lc.lc

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.util.Log
import com.baseapp.lc.lc.model.MainListModel
import java.util.*
import kotlin.collections.ArrayList

/**
 * 项目名称：LC
 * 类描述：
 * 创建人：chao.liu
 * 创建时间：2018/4/3 下午2:03
 * 修改人：chao.liu
 * 修改时间：2018/4/3 下午2:03
 * 修改备注：
 * @version
 */
/**
 * Repository handling the work with mainLists.
 */
class DataRepository{
    lateinit var mObservableMainLists :MediatorLiveData<List<MainListModel>>

    init {
        mObservableMainLists = MediatorLiveData()
        mObservableMainLists.addSource(getMainList(), { mainListEntities ->
            mObservableMainLists.postValue(mainListEntities)
        });
    }


    companion object {
         val sInstance :DataRepository by lazy { DataRepository() }
    }
    fun getMainList():LiveData<ArrayList<MainListModel>>{
        val resultes :MutableLiveData<ArrayList<MainListModel>> = MutableLiveData<ArrayList<MainListModel>>()
        var temp :ArrayList<MainListModel>  = ArrayList<MainListModel>();
        temp?.add(MainListModel("1title","1des"))
        temp?.add(MainListModel("2title","2des"))
        temp?.add(MainListModel("3title","3des"))
        resultes.value =temp
        Log.d("lc","${resultes.value?.size}resultes.value?.size")
        return resultes
    }
    fun getMediatorMainList() :MediatorLiveData<List<MainListModel>>{
        return mObservableMainLists
    }
}