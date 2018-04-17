package com.baseapp.lc.lc.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baseapp.lc.lc.R
import com.baseapp.lc.lc.databinding.MainListItemBinding
import com.baseapp.lc.lc.model.MainListModel
import com.baseapp.lc.lc.ui.MainListClickListener
import java.io.File
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.nio.file.Files
import java.nio.file.Paths

/**
 * 项目名称：LC
 * 类描述：
 * 创建人：chao.liu
 * 创建时间：2018/3/22 下午2:34
 * 修改人：chao.liu
 * 修改时间：2018/3/22 下午2:34
 * 修改备注：
 * @version
 */
class MainListAdapter :RecyclerView.Adapter<MainListAdapter.MainListViewHolder>{

    lateinit var mainLists:List<MainListModel>
    lateinit var mainListClickListener: MainListClickListener

    constructor(mainListClickListener: MainListClickListener){
        this.mainListClickListener = mainListClickListener
        mainLists =ArrayList()
    }

    fun setMainList(mainLists :List<MainListModel>){
        this.mainLists =mainLists
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainListViewHolder {
        val binding :MainListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent!!.context), R.layout.main_list_item,parent,false)
        return MainListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainListViewHolder?, position: Int) {
        holder?.binding?.mainListModel=mainLists.get(position)
        holder?.binding?.root?.setOnClickListener{
           mainListClickListener.onClick(mainLists.get(position))
        }

    }

    override fun getItemCount(): Int {
        return mainLists?.size
    }

    //    static class ProductViewHolder extends RecyclerView.ViewHolder {
//
//        final ProductItemBinding binding;
//
//        public ProductViewHolder(ProductItemBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//    }
//   internal class MainListViewHolder(val binding: MainListItemBinding) : RecyclerView.ViewHolder(binding.root)
       class MainListViewHolder: RecyclerView.ViewHolder {
        var binding :MainListItemBinding?=null
        constructor(binding: MainListItemBinding):super(binding.root){
            this.binding = binding
        }
    }
}

