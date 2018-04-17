package com.baseapp.lc.lc.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.Nullable
import com.baseapp.lc.lc.DataRepository
import com.baseapp.lc.lc.model.MainListModel

/**
 * 项目名称：LC
 * 类描述：主界面ViewModel
 * 创建人：chao.liu
 * 创建时间：2018/4/3 下午1:34
 * 修改人：chao.liu
 * 修改时间：2018/4/3 下午1:34
 * 修改备注：
 * @version
 */
class MainListViewModel :AndroidViewModel{
    lateinit var mObservableMainLists:MediatorLiveData<List<MainListModel>>
    constructor(application: Application) : super(application){

//        mObservableProducts = new MediatorLiveData<>();
//        // set by default null, until we get data from the database.
//        mObservableProducts.setValue(null);
//
//        LiveData<List<ProductEntity>> products = ((BasicApp) application).getRepository()
//                .getProducts();
//
//        // observe the changes of the products from the database and forward them
//        mObservableProducts.addSource(products, mObservableProducts::setValue);

        mObservableMainLists = MediatorLiveData()
        mObservableMainLists.value =null
        var mainLists :LiveData<List<MainListModel>> =DataRepository.sInstance.getMediatorMainList();
        mObservableMainLists.addSource(mainLists,object :Observer<List<MainListModel>>{
            override fun onChanged(t: List<MainListModel>?) {
                mObservableMainLists.value=t
            }
        })
//        mObservableMainLists.addSource(mainLists, object :Observer<List<MainListModel>> {
//            override fun onChanged(productEntities :List<MainListModel>){
//                mObservableMainLists.value =productEntities
//            }
//
//        })
//        mObservableMainLists.addSource()


    }
}