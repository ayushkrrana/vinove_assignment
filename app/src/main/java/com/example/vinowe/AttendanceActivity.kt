package com.example.vinowe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AttendanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAttendance)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch the list of members (this could be from a database or API)
        val members = getMembers()

        recyclerView.adapter = AttendanceAdapter(members)
    }

    // Function to get the member list (could be from a database or API in a real-world app)
    private fun getMembers(): List<Member> {
        return listOf(
            Member("Ayush Kumar", "789"),
            Member("Raushan Shahi", "101"),
            Member("Gopal Dhangar", "112"),
            Member("Arshad Khan", "131")

        )
    }
}
