package com.example.task

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso



class MyAdapter(val context :Activity, val UserArrayList : List<Data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(userView : View) : RecyclerView.ViewHolder(userView) {

        val name : TextView
        val email : TextView
        val  userImage : ShapeableImageView

        init {
            name = itemView.findViewById(R.id.tvname)
            email = itemView.findViewById(R.id.tvemail)
            userImage = itemView.findViewById(R.id.tvuser)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  itemview = LayoutInflater.from(context).inflate(R.layout.eachuser, parent,false)
        return MyViewHolder(itemview)
    }

    override fun getItemCount(): Int {
        return UserArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = UserArrayList[position]
        holder.name.text = currentItem.first_name
        holder.email.text = currentItem.email
        Picasso.get().load(currentItem.avatar).into(holder.userImage);


    }
}