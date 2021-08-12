package com.example.mvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmkotlin.data.model.User
import com.example.mvvmkotlin.databinding.ItemLayoutBinding

class MainAdapter(
    private val users: ArrayList<User>, private val clickListener: (User) -> Unit)
    : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DataViewHolder {
        val binding = ItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position],clickListener)

    class DataViewHolder(private val binding:  ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User, clickListener: (User) -> Unit) {
            binding.textViewUserName.text = user.name
            binding.textViewUserEmail.text = user.email
           binding.root.setOnClickListener { clickListener(user)}
        }
    }

    fun addData(list: List<User>) {
        users.addAll(list)
    }

}