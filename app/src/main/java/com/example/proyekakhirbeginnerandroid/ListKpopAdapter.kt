package com.example.proyekakhirbeginnerandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKpopAdapter(private val listKpop: ArrayList<Kpop>) : RecyclerView.Adapter<ListKpopAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kpop, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listKpop.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listKpop[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_DESCRIPTION", description)
            intent.putExtra("EXTRA_PHOTO", photo)
            intent.putExtra("GROUP_POSITION", position)
            context.startActivity(intent)
        }
    }
}