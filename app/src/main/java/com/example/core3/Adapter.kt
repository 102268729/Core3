package com.example.core03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.core3.Location
import com.example.core3.R


class Adapter(
    private val data: MutableList<Location>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
       val location = data[position]
        holder.bind(location)
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //variable defined
        private val stringmain: TextView = view.findViewById(R.id.mainString)
        private val stringsubtitle: TextView = view.findViewById(R.id.textView)
        private val imageicon: ImageView = view.findViewById(R.id.image)

        fun bind(location: Location) {
            stringmain.text = location.city
            stringsubtitle.text = location.timezone
            val axis = location.firstCoordinate.toString() + "," + location.secondCoordinate.toString()
            if (stringsubtitle.text == "Australia/Melbourne" || stringsubtitle.text == "Australia/Brisbane") {
                imageicon.setImageResource(R.drawable.download)
            }
            view.setOnClickListener {
                Toast.makeText(it.context, axis, Toast.LENGTH_LONG).show()
            }
        }

    }
}