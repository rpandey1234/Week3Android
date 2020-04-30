package edu.stanford.rkpandey.week3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contact.view.*

public class ContactAdapter(val context: Context, val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    // Expensive operation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = contacts.size

    // In-expensive operation
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Bind the data into the itemView
        fun bind(contact: Contact) {
            itemView.tvName.text = contact.name
            itemView.tvAge.text = "Age: ${contact.age}"
        }

    }
}