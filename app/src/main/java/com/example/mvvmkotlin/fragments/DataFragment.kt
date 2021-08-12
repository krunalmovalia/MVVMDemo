package com.example.mvvmkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmkotlin.adapter.MainAdapter
import com.example.mvvmkotlin.api.ApiHelper
import com.example.mvvmkotlin.api.ApiServiceImpl
import com.example.mvvmkotlin.base.BaseFragment
import com.example.mvvmkotlin.base.ViewModelFactory
import com.example.mvvmkotlin.data.model.User
import com.example.mvvmkotlin.databinding.FragmentDataBinding
import com.example.mvvmkotlin.utils.Status
import com.example.mvvmkotlin.viewmodel.MainViewModel


class DataFragment : BaseFragment(){

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root

        setupUI(binding)
        setupViewModel()
        setupObserver(binding)

        return view
    }

    private fun setupUI( binding: FragmentDataBinding) {


        binding.recyclerView.layoutManager = LinearLayoutManager(getCurrentActivity())
        adapter = MainAdapter(arrayListOf(), this::passData)
        binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                        binding.recyclerView.context,
                        (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun passData(user: User) {
        getCurrentActivity()?.addFragment(ShowDataFragment.newInstance(user))
    }


    private fun setupObserver(binding:  FragmentDataBinding) {

        getCurrentActivity()?.let {
            mainViewModel.getUsers().observe(it,  {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        it.data?.let { users -> renderList(users) }
                        binding.recyclerView.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        binding.progressBar.visibility = View.GONE
                    }
                }
            })
        }
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }

    companion object {
        fun newInstance() = DataFragment()
    }


}