package com.jason.rxjavamvvmdagger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jason.rxjavamvvmdagger.MyApplication
import com.jason.rxjavamvvmdagger.R
import com.jason.rxjavamvvmdagger.data.GoRestViewModel
import com.jason.rxjavamvvmdagger.databinding.ActivityMainBinding
import javax.inject.Inject

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewAdapter = UserAdapter()
    @Inject
    lateinit var viewModel: GoRestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyApplication.appComponent.inject(this)
        initLayout()
    }

    private fun initLayout() {
        viewModel.userLiveData.observe(this, Observer {
            it.map { user->
                Log.d(TAG, "get User $user")
            }
            viewAdapter.updateList(it)
        })
        binding.buttonGetUserList.setOnClickListener {

            viewModel.getAllUser()

        }
        binding.recyclerUserList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter
        }
    }


}