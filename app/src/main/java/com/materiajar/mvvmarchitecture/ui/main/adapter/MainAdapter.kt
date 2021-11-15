package com.materiajar.mvvmarchitecture.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.materiajar.mvvmarchitecture.R
import com.materiajar.mvvmarchitecture.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
            itemView.textViewUserName.text = user.name
            itemView.textViewUserName.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return  DataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        return holder.bind(users[position])
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}