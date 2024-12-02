package com.example.vinowe

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set up button click listener to navigate to AttendanceActivity
        val button = findViewById<Button>(R.id.buttonStartAttendance)
        button.setOnClickListener {
            startActivity(Intent(this, AttendanceActivity::class.java))
        }
    }

    // Corrected position for onOptionsItemSelected()
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_attendance -> {
                // Start AttendanceActivity
                startActivity(Intent(this, AttendanceActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
