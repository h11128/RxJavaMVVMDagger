package com.jason.rxjavamvvmdagger.ui

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jason.rxjavamvvmdagger.R
import com.jason.rxjavamvvmdagger.data.model.User
import com.jason.rxjavamvvmdagger.databinding.AdapterUserBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private lateinit var binding: AdapterUserBinding
    private var userList:List<User> = listOf()
    class UserViewHolder(private val binding: AdapterUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.textView2.text = user.name
            binding.textView.text = user.id.toString()
            binding.textView3.text = user.gender
            binding.textView4.text = user.email
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_user, parent, false)
        binding = AdapterUserBinding.bind(view)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateList(newList: List<User>){
        userList = newList
        notifyDataSetChanged()
    }
}