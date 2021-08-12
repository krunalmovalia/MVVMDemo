package com.example.mvvmkotlin.base

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {



    open fun onBack():Boolean {
        return true
    }


    fun getCurrentActivity(): BaseActivity? {
        activity?.let {
            if (it is BaseActivity){
                return it as BaseActivity
            }
            else{
                return null
            }
        }?:return null
    }

}