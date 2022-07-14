package com.example.aethanalyticandroidmachinetest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aethanalyticandroidmachinetest.api.RetrofitClient
import com.example.aethanalyticandroidmachinetest.dataClass.Model
import com.example.aethanalyticandroidmachinetest.dataClass.ModelItem
import com.example.aethanalyticandroidmachinetest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var squareListAdapter: SquareListAdapter
    var list: MutableList<ModelItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSquareData()
        squareListAdapter = SquareListAdapter(list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = squareListAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun getSquareData() {

        RetrofitClient.getPublicService(this)
            .listSquareProduct()
            .enqueue(object :
                Callback<Model> {
                override fun onResponse(
                    call: Call<Model>,
                    response: Response<Model>
                ) {
                    Log.v("Recipient response : ", response.body().toString())
                    val result = response.body()
                    if (result != null) {

                        list.addAll(result)
                        squareListAdapter.notifyDataSetChanged()

                    }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {

                }
            })
    }


}
