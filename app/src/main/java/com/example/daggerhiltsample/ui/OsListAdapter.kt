package com.example.daggerhiltsample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhiltsample.R
import com.example.daggerhiltsample.model.Android
import kotlinx.android.synthetic.main.item_layout.view.*

class OsListAdapter(
    private val osList: ArrayList<Android>
) : RecyclerView.Adapter<OsListAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(android: Android) {
          itemView.tv_name.text = android.name
          itemView.tv_version.text = android.ver
          itemView.tv_api_level.text = android.api
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )

        )

    override fun getItemCount(): Int = osList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(osList[position])

    fun addData(list: List<Android>) {
        osList.addAll(list)
    }
}