package com.example.vinowe

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AttendanceAdapter(private val members: List<Member>) :
    RecyclerView.Adapter<AttendanceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.textViewName)
        val locationButton: ImageButton = view.findViewById(R.id.buttonLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_attendance, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member = members[position]
        holder.nameTextView.text = member.name

        // Set click listener for the location button
        holder.locationButton.setOnClickListener {
            val context = it.context
            openLocationActivity(context, member)
        }
    }

    override fun getItemCount(): Int = members.size

    // Function to open LocationActivity with member details
    private fun openLocationActivity(context: Context, member: Member) {
        val intent = Intent(context, LocationActivity::class.java).apply {
            putExtra("memberId", member.id) // Pass member ID
            putExtra("memberName", member.name) // Pass member name (optional)
        }
        context.startActivity(intent)
    }
}
