package com.example.recyclerview_v1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG  = "ContactAdapter"

class ContactAdapter(val context: Context, val contacts:MutableList<Person>):
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    //Creating new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        Log.i(TAG,"oncreateviewholder function accessed")
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }
    //Binding data to the views
    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        Log.i(TAG,"onBuildViewHolder $position")
        val contact  = contacts[position]
        holder.tvName.text = contact.name
        holder.tvage.text = "Age: ${contact.age}"
    }

    //get the no of items in the dataset
    override fun getItemCount()= contacts.size

    //Defining data for each view inside the item_layout
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tvName: TextView = itemView.findViewById(R.id.tvpersonname)
        val tvage: TextView = itemView.findViewById(R.id.tvage)

        fun bind (contact: Person){
            tvName.text = contact.name
            tvage.text = "Age: ${contact.age}"
        }
    }

}
