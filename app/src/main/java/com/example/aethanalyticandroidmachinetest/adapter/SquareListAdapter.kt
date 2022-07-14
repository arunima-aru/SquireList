package com.example.aethanalyticandroidmachinetest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aethanalyticandroidmachinetest.dataClass.ModelItem
import com.example.aethanalyticandroidmachinetest.databinding.ListItemSquareBinding


class SquareListAdapter(private val list: List<ModelItem>) :
    RecyclerView.Adapter<SquareListAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val binding = ListItemSquareBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val list = list[position]

        holder.binding.textView1.text = list.name
        holder.binding.textView2.text = list.description
        holder.binding.root.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CustomViewHolder(val binding: ListItemSquareBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}