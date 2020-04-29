package edu.stanford.rkpandey.week3

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

public class ContactAdapter(val context: Context, val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented")
    }

    override fun getItemCount(): Int {
        TODO("not implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented")
    }
}