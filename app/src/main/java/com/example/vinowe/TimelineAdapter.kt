package com.example.vinowe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimelineAdapter(private var locations: List<VisitedLocation>) : RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_timeline, parent, false)
        return TimelineViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        val location = locations[position]
        holder.name.text = location.name
        holder.date.text = location.date.toString()  // Format it as needed
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    fun updateData(newLocations: List<VisitedLocation>) {
        locations = newLocations
        notifyDataSetChanged()
    }



    class TimelineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.locationName)
        val date: TextView = itemView.findViewById(R.id.locationDate)
    }
}
