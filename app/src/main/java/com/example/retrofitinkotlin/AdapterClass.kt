package com.example.retrofitinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(var list: List<MyDataItem>) : RecyclerView.Adapter<AdapterClass.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewcard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.idUser.text = list[position].userId.toString()
        holder.title.text = list[position].title
        holder.body.text = list[position].body
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val id : TextView = item.findViewById(R.id.id)
        val idUser : TextView = item.findViewById(R.id.idUser)
        val title : TextView = item.findViewById(R.id.title)
        val body : TextView = item.findViewById(R.id.body)
    }
}