package com.example.newvitameanshospital.ui.calendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.ActivityCalendarBinding

class CalendarAct : AppCompatActivity() {

    lateinit var binding: ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calendar)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}
