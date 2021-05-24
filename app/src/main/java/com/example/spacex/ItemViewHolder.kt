package com.example.spacex

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val patchImage : ImageView = view.findViewById(R.id.patchImage)
    val patchName: TextView = view.findViewById(R.id.patchName)
    val patchDate: TextView = view.findViewById(R.id.patchDate)
    val patchStatus: TextView = view.findViewById(R.id.patchStatus)
}