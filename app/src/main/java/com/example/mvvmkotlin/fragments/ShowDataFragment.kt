package com.example.mvvmkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmkotlin.base.BaseFragment
import com.example.mvvmkotlin.base.KEY_EMAIL_DATA
import com.example.mvvmkotlin.base.KEY_NAME_DATA
import com.example.mvvmkotlin.data.model.User
import com.example.mvvmkotlin.databinding.FragmentShowDataBinding

class ShowDataFragment : BaseFragment() {

    companion object {

        fun newInstance(user: User): ShowDataFragment {
            val displayFoodFragment = ShowDataFragment()

            val bundle = Bundle()
            bundle.putString(KEY_NAME_DATA, user.name)
            bundle.putString(KEY_EMAIL_DATA, user.email)
            displayFoodFragment.arguments = bundle

            return displayFoodFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentShowDataBinding.inflate(inflater, container, false)
        val view = binding.root

        arguments?.let { bundle ->
            if (bundle.containsKey(KEY_NAME_DATA)) {
                binding.displayValueName.text = bundle.getString(KEY_NAME_DATA)
            }
        }

            arguments?.let { bundle ->
                if (bundle.containsKey(KEY_EMAIL_DATA)) {
                    binding.displayValueEmail.text = bundle.getString(KEY_EMAIL_DATA)
                }
            }

            return view
        }
    }

