package com.example.spacex

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LaunchAdapter(private val dataSet: List<LaunchResponse>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.launch_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.patchName.text = dataSet[position].name
        Glide.with(holder.itemView).load(dataSet[position].links.patch.small)
            .placeholder(R.drawable.ic_launcher_foreground).into(holder.patchImage)
        holder.patchDate.text = dataSet[position].date
        dataSet[position].success.let { success->
            when {
                success == null -> {
                    holder.patchStatus.text = holder.itemView.resources.getString(R.string.upcoming)
                    holder.patchStatus.setTextColor(holder.itemView.resources.getColor(R.color.purple_500, null))
                }
                success -> {
                    holder.patchStatus.text = holder.itemView.resources.getString(R.string.success)
                    holder.patchStatus.setTextColor(holder.itemView.resources.getColor(R.color.green, null))
                }
                else -> {
                    holder.patchStatus.text = holder.itemView.resources.getString(R.string.failure)
                    holder.patchStatus.setTextColor(holder.itemView.resources.getColor(R.color.red, null))
                }
            }
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("ROCKET_ID", dataSet[position].rocket)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}