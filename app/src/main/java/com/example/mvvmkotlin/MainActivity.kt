package com.example.mvvmkotlin

import android.os.Bundle
import com.example.mvvmkotlin.base.BaseActivity
import com.example.mvvmkotlin.fragments.DataFragment

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is mvvm - demo project
        addFragment(DataFragment.newInstance())
    }


}