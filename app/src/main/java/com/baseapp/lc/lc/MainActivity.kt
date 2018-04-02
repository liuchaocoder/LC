package com.baseapp.lc.lc

import android.content.ContentValues.TAG
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.baseapp.lc.lc.model.MainListModel
import com.baseapp.lc.lc.ui.MainListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add main list fragment if this is first creation
        if(savedInstanceState==null){
            val mainListFragment : MainListFragment = MainListFragment();
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,mainListFragment,MainListFragment.TAG).commit()
        }
    }
}
