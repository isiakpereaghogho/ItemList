package com.example.restapp
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.restapp.databinding.ItemBinding

class ListAdapter(var list: List<Item>): RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.textview.text =item.name
        }

      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val singleItem = list.get(position)
        holder.bind(singleItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
